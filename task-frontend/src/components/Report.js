import React, { useState, useEffect } from "react";
import axios from "axios";
import * as XLSX from "xlsx";
import { Card, Button, Row, Col } from "react-bootstrap";

const Report = () => {
  const [formDataList, setFormDataList] = useState([]);

  useEffect(() => {
    const fetchFormData = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8083/form/getAllForms"
        );
        setFormDataList(response.data);
      } catch (error) {
        console.error("Error fetching form data:", error);
      }
    };

    fetchFormData();
  }, []);

  const exportToExcel = () => {
    const ws = XLSX.utils.json_to_sheet(formDataList);
    const wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, "Form Data");
    XLSX.writeFile(wb, "form_data.xlsx");
  };

  return (
    <div>
      <h1 className="text-center">Form Submission Report</h1>
      <div className="text-center mt-3 mb-3">
        <Button onClick={exportToExcel}>Export to Excel</Button>
      </div>
      <Row xs={1} md={2} lg={3} xl={4} className="g-4">
        {formDataList.map((formData) => (
          <Col key={formData.userId}>
            <Card className="custom-card">
              <Card.Body>
                <Card.Title>User ID: {formData.userId}</Card.Title>
                <Card.Subtitle>User Name: {formData.userName}</Card.Subtitle>
                <Card.Text>Github Link: {formData.userGithub}</Card.Text>
                {/* Add more Card.Text or customization based on your data */}
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
};

export default Report;

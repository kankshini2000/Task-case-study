import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Form from "./components/Form";
import Home from "./components/Home";
import Report from "./components/Report";
import Thankyou from "./components/Thankyou";
import Login from "./components/Login";

function App() {
  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route path="/form" element={<Form />} />
        <Route path="/report" element={<Report />} />
        <Route path="/thankyou" element={<Thankyou />} />
        <Route path="/" element={<Login />} />
      </Routes>
      {/* <Form /> */}
      <Footer />
    </div>
  );
}

export default App;

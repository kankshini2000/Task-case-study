import React, { useState, useEffect, useCallback } from "react";

import axios from "axios";

import { useNavigate } from "react-router-dom";

const Form = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    userId: "",

    userName: "",

    userGithub: "",

    startTime: "",

    endTime: "",

    question: "",
  });

  const [timer, setTimer] = useState(0);

  const [timeStarted, setTimeStarted] = useState(false);

  const [submitted, setSubmitted] = useState(false);

  const [startTime, setStartTime] = useState("");

  const [timerExpired, setTimerExpired] = useState(false);

  const [question, setQuestion] = useState("");

  useEffect(() => {
    // Fetch question from the database when the component mounts
    const fetchQuestion = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8084/api/questions/random"
        );
        setQuestion(response.data.question);
        console.log(response);
        console.log(setQuestion);
      } catch (error) {
        console.error("Error fetching question:", error);
      }
    };

    fetchQuestion();
  }, []);
  const startTimer = () => {
    setTimer(30);

    setTimeStarted(true);

    // Set startTime when the timer starts

    const startTimeValue = new Date().toLocaleTimeString();

    setStartTime(startTimeValue);

    setFormData((prevData) => ({
      ...prevData,

      startTime: startTimeValue,
    }));
  };

  useEffect(() => {
    let interval;

    if (timeStarted) {
      interval = setInterval(() => {
        setTimer((prevTimer) => {
          if (prevTimer === 0 && !timerExpired) {
            clearInterval(interval);
            setTimerExpired(true);
            //handleAutoSubmit();

            //return 0;
          }

          return prevTimer - 1;
        });
      }, 1000);
    }

    return () => clearInterval(interval);
  }, [timeStarted, timerExpired]);

  useEffect(() => {
    if (timerExpired) {
      handleAutoSubmit();
    }
  }, [timerExpired]);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData((prevData) => ({
      ...prevData,

      [name]: value,
    }));
  };

  const { userId, userName, userGithub } = formData;

  const handleManualSubmit = async (e) => {
    try {
      if (e) {
        e.preventDefault();
      }

      // Set endTime when the form is submitted

      const endTime = new Date().toLocaleTimeString();

      setFormData((prevData) => ({
        ...prevData,

        endTime: endTime,
      }));

      // Include startTime and endTime in the form data

      const formWithTime = {
        ...formData,

        startTime: startTime, // Use the startTime variable here

        endTime: endTime,

        question,
      };

      console.log("Data being sent:", formWithTime);
      await axios.post(`http://localhost:8083/form`, formWithTime);
      console.log("Data being sent:", formWithTime);
      navigate("/Thankyou");

      setTimeStarted(false);

      setSubmitted(true);
    } catch (error) {
      console.error("Error submitting form:", error);
    }
  };

  const handleAutoSubmit = async (e) => {
    try {
      let { userId, userName, userGithub } = formData;
      const endTime = new Date().toLocaleTimeString();
      const formWithTime = {
        userId,
        userName,
        userGithub,
        startTime: formData.startTime,
        endTime: endTime,
        question,
      };

      setFormData(formWithTime);
      console.log(formWithTime);
      await axios.post(`http://localhost:8083/form`, formWithTime);
      navigateToReport(formWithTime);
      setTimeStarted(false);
      setSubmitted(true);
    } catch (error) {
      console.error("Error auto-submitting form:", error);
    }
  };

  const navigateToReport = (formData) => {
    navigate("/Thankyou", { state: { submitData: formData } });
    setFormData({
      userId: "",
      userName: "",
      userGithub: "",
      startTime: "",
      endTime: "",
      question: "",
    });
    setTimeStarted(false);
    setSubmitted(true);
  };
  const progressBarStyle = {
    width: `${(timer / 30) * 100}%`,

    height: "10px",

    background: "green",

    marginTop: "5px",
  };

  return (
    <div className="card-container">
      <div className="card">
        <h1>Microsoft Form</h1>

        {submitted ? (
          <div>
            <p>Thank you for submitting the form!</p>
            {/* <p><a href="/report">Go to Report</a></p> */}
          </div>
        ) : timeStarted ? (
          <>
            <div style={progressBarStyle}></div>

            <form onSubmit={handleManualSubmit}>
              <p>Question: {question}</p>

              <label>
                User ID:
                <input
                  type="text"
                  name="userId"
                  value={userId}
                  onChange={handleChange}
                />
              </label>

              <label>
                User Name:
                <input
                  type="text"
                  name="userName"
                  value={userName}
                  onChange={handleChange}
                />
              </label>

              <label>
                Github Link:
                <input
                  type="text"
                  name="userGithub"
                  value={userGithub}
                  onChange={handleChange}
                />
              </label>

              <button type="submit">Submit</button>
            </form>
          </>
        ) : (
          <button onClick={startTimer} disabled={timeStarted}>
            Start Timer
          </button>
        )}

        {timeStarted && (
          <p>
            {timer === 0
              ? "Time has ended!"
              : `Time remaining: ${timer} seconds`}
          </p>
        )}
      </div>
    </div>
  );
};

export default Form;

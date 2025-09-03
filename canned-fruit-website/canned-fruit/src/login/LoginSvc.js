import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom/client";
import { Link, MemoryRouter } from "react-router-dom";
import CustomerList from "./CustomerList.js";
import CustomerAdd from "../customer-add/CustomerAdd.tsx";
import CustomerDel from "../customer-del/CustomerDel.tsx";
import CustomerUpd from "../customer-upd/CustomerUpd.tsx";

function LoginSvc(props) {
  const ChildTag = props.child;
  var [customerData, setCustomerData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [inputs, setInputs] = useState("");
  const [inputCnt, setInputCnt] = useState(0);
  const [emailAddress, setEmailAddress] = useState(props.emailAddress);

  /*   const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    if (inputCnt == 0) {
      setInputs((values) => (values+"?"+name+"="+value));
    } else {
      setInputs((values) => (values+"&"+name+"="+value));
    }
    setInputCnt(prevInputCnt => prevInputCnt+1);
  }; */
  const handleSubmit = async (event) => {
    event.preventDefault();
    //TODO make that a global
    if (emailAddress == "admin@cfdist.com") {
      root.render(
        <MemoryRouter>
          <ShippingRoute />
        </MemoryRouter>
      );
    } else {
      let url = "http://localhost:8081/api2/customer/pocEmail/" + emailAddress;
      url = url.replace(/ /g, "%20");
      console.log(url); ////////
      try {
        const response = await fetch(url, {
          method: "GET",
        });
        if (response.ok) {
          let data = await response.json();
          //console.log(JSON.stringify(data)); ///////
          customerData = [...customerData, ...data]; // for some reason, useState setCustomerData does not work
        } else {
          console.error("Error:", response.status);
        }
      } catch (error) {
        console.error("Error:", error);
      } finally {
        await setLoading(false);
      }
      console.log(customerData); ///////
      const root = ReactDOM.createRoot(document.getElementById("root"));
      root.render(
        <MemoryRouter>
          <HomePage customers={customerData} />
        </MemoryRouter>
      );
    }
    //window.location.reload();  //TODO added to make link work; try to find a cheaper way
  };

  return (
    <>
      <p />
      <form onSubmit={handleSubmit}>
        <label>
          Email Address:
          <input
            type="text"
            name="emailAddress"
            value={emailAddress}
            onChange={(e) => setEmailAddress(e.target.value)}
          />
          &nbsp;
        </label>
        <p />
        <input type="submit" />
      </form>
    </>
  );
}

export default LoginSvc;

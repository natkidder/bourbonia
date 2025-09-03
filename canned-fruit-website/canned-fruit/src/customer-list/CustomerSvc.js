import React, { useState, useEffect } from "react";
import ReactDOM from "react-dom/client";
import { Link, MemoryRouter } from "react-router-dom";
import CustomerList from "./CustomerList.js";
import CustomerAdd from "../customer-add/CustomerAdd.tsx";
import CustomerDel from "../customer-del/CustomerDel.tsx";
import CustomerUpd from "../customer-upd/CustomerUpd.tsx";

function CustomerSvc(props) {
  const ChildTag = props.child;
  var [customerData, setCustomerData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [inputs, setInputs] = useState("");
  const [inputCnt, setInputCnt] = useState(0);
  const [businessName, setBusinessName] = useState(props.businessName);
  const [outletName, setOutletName] = useState(props.outletName);
  const [pocFirst, setPocFirst] = useState(props.pocFirst);
  const [pocLast, setPocLast] = useState(props.pocLast);
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
    let url =
      "http://localhost:8081/api2/customer?businessName=" +
      businessName +
      "&outletName=" +
      outletName +
      "&pocFirst=" +
      pocFirst +
      "&pocLast=" +
      pocLast; ///////
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
    if (ChildTag == "CustomerList") {
      root.render(
        <MemoryRouter>
          <CustomerList customers={customerData} />
        </MemoryRouter>
      );
    } else if (ChildTag == "CustomerAdd") {
      root.render(
        <MemoryRouter>
          <CustomerAdd
            customers={customerData}
            businessName={businessName}
            outletName={outletName}
            pocFirst={pocFirst}
            pocLast={pocLast}
          />
        </MemoryRouter>
      );
    } else if (ChildTag == "CustomerUpd") {
      root.render(
        <MemoryRouter>
          <CustomerUpd
            customers={customerData}
            businessName={businessName}
            outletName={outletName}
            pocFirst={pocFirst}
            pocLast={pocLast}
          />
        </MemoryRouter>
      );
    } else if (ChildTag == "CustomerDel") {
      root.render(
        <MemoryRouter>
          <CustomerDel
            customers={customerData}
            businessName={businessName}
            outletName={outletName}
            pocFirst={pocFirst}
            pocLast={pocLast}
          />
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
          Business:
          <input
            type="text"
            name="businessName"
            value={businessName}
            onChange={(e) => setBusinessName(e.target.value)}
          />
          &nbsp;
        </label>
        <label>
          Outlet:
          <input
            type="text"
            name="outletName"
            value={outletName}
            onChange={(e) => setOutletName(e.target.value)}
          />
          &nbsp;
        </label>
        <label>
          POC First:
          <input
            type="text"
            name="pocFirst"
            value={pocFirst}
            onChange={(e) => setPocFirst(e.target.value)}
          />
          &nbsp;
        </label>
        <label>
          POC Last:
          <input
            type="text"
            name="pocLast"
            value={pocLast}
            onChange={(e) => setPocLast(e.target.value)}
          />
          &nbsp;
        </label>
        <p />
        <input type="submit" />
      </form>
    </>
  );
}

export default CustomerSvc;

import { React, useState, useEffect } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "../cannedFruit-list/CannedFruitList.css";
import CurrencyDisplay from "../utils/CurrencyDisplay";
import { Link, MemoryRouter } from "react-router-dom";
import HomePage from "./HomePage_zod.tsx";

function IndivCannedFruit(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.fruit} </td>
      <td> {props2?.medium?.mediumName}</td>
      <td> {props2.unitType}</td>
      <td> {props2.volume}</td>
      <td> {props2.container}</td>
      <td>
        {" "}
        <CurrencyDisplay amount={props2.pricePer} />
      </td>
      <td>
        {" "}
        <input type="checkbox" name={`isOrdering_${props2.id}`} value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function Sandbox(props) {
  //const customer = props.customer;
  const [allCannedFruits, setAllCannedFruits] = useState([]);
  var [ordCannedFruits, setOrdCannedFruits] = useState([]);
  const [pocEmail, setPocEmail] = useState("");
  var [customers, setCustomers] = useState([]);
  var [customer, setCustomer] = useState({});
  var [shippings, setShippings] = useState([]);
  var [count, setCount] = useState(0); //// for testing useState
  //var [data, setData] = useState({});
  const [inputs, setInputs] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const cannedFruit = async () => {
      try {
        const response = await fetch("http://localhost:8081/api2/cannedFruit");
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        //console.log(result); ///////
        setAllCannedFruits(result);
      } catch (err) {
        setError(err);
      } finally {
        await setLoading(false);
      }
    };
    cannedFruit();
  }, []);
  useEffect(() => {
    const shipping = async () => {
      try {
        const response = await fetch("http://localhost:8081/api2/shipping");
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        setShippings(result);
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };
    shipping();
  }, []);
  const handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    var getIDs = "";
    let cnt = 0;
    var jsonOptions = Object.keys(json).map(function (key) {
      if (key.lastIndexOf("isOrdering_", 0) === 0) {
        let ordCannedFruitId = json[key];
        if (cnt == 0) {
          getIDs = getIDs + "?id=" + ordCannedFruitId;
        } else {
          getIDs = getIDs + "&id=" + ordCannedFruitId;
        }
        cnt += 1;
      }
    });
    //    console.log(getIDs); //////////
    // set the selected canned fruit offerings the customer wants to order
    let url = "http://localhost:8081/api2/cannedFruit/idCollection" + getIDs;
    //    console.log(url); ///////
    try {
      // await is required for the web svc call to work, but cannot be called inside a loop
      // we cannot make it a function, as functions must return HTML elements
      const response = await fetch(url, {
        method: "GET",
      });
      if (response.ok) {
        let data = await response.json();
        ordCannedFruits = [...ordCannedFruits, ...data]; // for some reason, useState setOrdCannedFruits does not work
      } else {
        console.error("Error:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    } finally {
      await setLoading(false);
    }
    //    console.log(ordCannedFruits); ////////
    // set the customer based on the POC's email
    url = "http://localhost:8081/api2/customer/pocEmail/" + pocEmail;
    try {
      // await is required for the web svc call to work, but cannot be called inside a loop
      // we cannot make it a function, as functions must return HTML elements
      const response = await fetch(url, {
        method: "GET",
      });
      if (response.ok) {
        let data = await response.json();
        customers = [...customers, data]; // for some reason, useState setCustomer(data) does not work, & customer must be an array
        if (customers.length > 0) {
          customer = customers.at(0); // setCustomer, even in a top-level function, did not work
          incrementCount(); ///////
          //console.log(customer); ////////
        }
      } else {
        console.error("Error:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    } finally {
      await setLoading(false);
    }
    const root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <HomePage ordCannedFruits={ordCannedFruits} customer={customer} shippings={shippings} count={count} />
      </MemoryRouter>
    );
    //window.location.reload(); //TODO added to make link work; try to find a cheaper way
  };
  const incrementCount = () => {
    ///////
    setCount((prevCount) => prevCount + 1); ///////
  }; ///////
  return (
    <>
      <form onSubmit={handleSubmit}>
        <label>
          Customer POC email:&nbsp;
          <input type="text" size={35} name="pocEmail" value={pocEmail} onChange={(e) => setPocEmail(e.target.value)} />
          &nbsp;
        </label>
        <h1>CannedFruit Offerings to Order</h1>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Fruit</th>
              <th>Medium</th>
              <th>Preparation</th>
              <th>Volume (Oz)</th>
              <th>Container</th>
              <th>Price per Oz</th>
              <th>Order?</th>
            </tr>
          </thead>
          <tbody>
            {allCannedFruits.map((cannedFruit) => (
              <IndivCannedFruit
                id={cannedFruit.id}
                fruit={cannedFruit.fruit}
                medium={cannedFruit.medium}
                unitType={cannedFruit.unitType}
                volume={cannedFruit.volume}
                container={cannedFruit.container}
                pricePer={cannedFruit.pricePer}
              />
            ))}
          </tbody>
        </table>
        <input type="submit" />
      </form>
      <p></p>
      <Link to="/">Back to Home</Link>
    </>
  );
}

//const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<CannedFruitSvc child="CannedFruitOrd" />);
export default Sandbox;

/*
async function buildOrdCannedFruits(id, ordCannedFruits, error, loading) {
  useEffect(() => {
    const cannedFruit = async () => {
      try {
        const response = await fetch(
          "http://localhost:8081/api2/cannedFruit/" + id,
          {
            method: "GET",
          }
        );
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        //console.log(result); ///////
        ordCannedFruits = [...ordCannedFruits, ...result]; // for some reason, useState setOrdCannedFruits does not work
      } catch (err) {
        setError(err);
      } finally {
        await setLoading(false);
      }
    };
    cannedFruit();
  }, []);

  */

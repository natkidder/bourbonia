import React from "react";
import ReactDOM from "react-dom/client";
import { useState, useEffect } from "react";
import "../cannedFruit-list/CannedFruitList.css";
import CannedFruitSvc from "../cannedFruit-list/CannedFruitSvc";
import CurrencyDisplay from "../utils/CurrencyDisplay";
import { Link, MemoryRouter, BrowserRouter } from "react-router-dom";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";

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
        <input type="checkbox" name={`isDeleting_${props2.id}`} value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function CannedFruitDel(props) {
  //let root = ReactDOM.createRoot(document.getElementById("root"));
  const cannedFruit = props.cannedFruit;
  const customer = props.customer;
  const [inputs, setInputs] = useState({});
  const [isNotWaiting, setIsNotWaiting] = useState(true);
  const delay = (ms) => new Promise((res) => setTimeout(res, ms));
  const handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    console.log(json); ///////
    var jsonOptions = Object.keys(json).map(function (key) {
      let deletingCannedFruitId = json[key];
      //console.log(deletingCannedFruitId); ///////
      //return <CannedFruitDelSvc id={deletingCannedFruitId} />
      CannedFruitDelSvc2(deletingCannedFruitId);
    });
    setIsNotWaiting(false);
    await delay(5000); // wait for 5 seconds to let the delete operations complete
    setIsNotWaiting(true);
    let root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <CannedFruitSvc child="CannedFruitDel" />
      </MemoryRouter>
    );
    //window.location.reload(); //TODO added to make link work; try to find a cheaper way
  };
  const handleRouter = () => {
    let root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <BrowserRouter>
        <ShippingRoute2 />
      </BrowserRouter>
    );
  };
  return (
    <>
      <h1>CannedFruit Offerings to Remove</h1>
      <form onSubmit={handleSubmit}>
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
              <th>Del?</th>
            </tr>
          </thead>
          <tbody>
            {cannedFruit.map((cannedFruit) => (
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

        <input type="submit" value="Confirm Remove" />
      </form>
      <div hidden={isNotWaiting}>
        <br />
        Please wait ...
      </div>
      <p></p>
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}

//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(<AllCannedFruit />);

async function CannedFruitDelSvc2(id) {
  try {
    const response = await fetch("http://localhost:8081/api2/cannedFruit/" + id, {
      method: "DELETE",
    });
    await console.log("sent delete request for id ", id, "response.status", response.status); ////////
    if (response.ok) {
      //const data = await response.json();
      //console.log("Success:", data);
      console.log("Success in removing ID ", id); //////
    } else {
      console.error("Error:", response.status);
    }
  } catch (error) {
    console.error("Error:", error);
  }
  //const root = ReactDOM.createRoot(document.getElementById('root'));
  // root.render(<CannedFruitSvc child="CannedFruitDel" />);
}
export default CannedFruitDel;

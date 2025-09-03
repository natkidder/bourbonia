import React from "react";
import ReactDOM from "react-dom/client";
import { useState, useEffect } from "react";
import "../shipping-list/ShippingList.css";
import ShippingSvc from "../shipping-list/ShippingSvc";
import { Link, MemoryRouter, BrowserRouter } from "react-router-dom";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";

function IndivShipping(props2) {
  return (
    <tr>
      <td> {props2.id} </td>
      <td> {props2.type} </td>
      <td> ${props2.price}</td>
      <td>
        {" "}
        <input type="checkbox" name={`isDeleting_${props2.id}`} value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function ShippingDel(props) {
  const shipping = props.shipping;
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
      let deletingShippingId = json[key];
      console.log(deletingShippingId); ///////
      //return <ShippingDelSvc id={deletingShippingId} />
      ShippingDelSvc2(deletingShippingId);
      //window.location.reload(); //TODO added to make link work; try to find a cheaper way
    });
    setIsNotWaiting(false);
    await delay(5000); // wait for 5 seconds to let the delete operations complete
    setIsNotWaiting(true);
    let root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <ShippingSvc child="ShippingDel" />
      </MemoryRouter>
    );
  };
  const handleRouter = () => {
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <BrowserRouter>
        <ShippingRoute2 />
      </BrowserRouter>
    );
  };
  return (
    <>
      <h1>Remove Shipping Terms</h1>
      <form onSubmit={handleSubmit}>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Type</th>
              <th>Price</th>
              <th>Remove?</th>
            </tr>
          </thead>
          <tbody>
            {shipping.map((shipping) => (
              <IndivShipping id={shipping.id} type={shipping.type} price={shipping.price} />
            ))}
          </tbody>
        </table>
        <br />
        <input type="submit" value="Confirm Remove" />
      </form>
      <p></p>
      <div hidden={isNotWaiting}>
        <br />
        Please wait ...
      </div>
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<AllShipping />);

async function ShippingDelSvc2(id) {
  try {
    const response = await fetch("http://localhost:8081/api2/shipping/" + id, {
      method: "DELETE",
    });

    if (response.ok) {
      const data = await response.json();
      console.log("Success:", data);
    } else {
      console.error("Error:", response.status);
    }
  } catch (error) {
    console.error("Error:", error);
  }
  //const root = ReactDOM.createRoot(document.getElementById('root'));
  // root.render(<ShippingSvc child="ShippingDel" />);
}
export default ShippingDel;

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
        <input type="radio" name="updRadios" value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function ShippingUpd(props) {
  console.log(props); //////
  const shipping = props.shipping;
  const chosenShipping = props.chosenShipping;
  //console.log(chosenShipping); ///////
  const [inputs, setInputs] = useState({});
  const [selectedOption, setSelectedOption] = useState("");
  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs((values) => ({ ...values, [name]: value }));
  };
  const handleChoice = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    var data = "";
    try {
      const response = await fetch("http://localhost:8081/api2/shipping/" + json.updRadios, {
        method: "GET",
      });
      if (response.ok) {
        let data = await response.json();
        setInputs(data);
        console.log("Success:", inputs);
      } else {
        console.error("Error:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };
  const handleSubmit = async (event) => {
    event.preventDefault();
    event.preventDefault();
    console.log(inputs);
    try {
      const response = await fetch("http://localhost:8081/api2/shipping/" + inputs.id, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(inputs),
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
    let root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <MemoryRouter>
        <ShippingSvc child="ShippingUpd" />
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
      <h1>Shipping Terms</h1>
      <h2>Select Shipping Term</h2>
      <form onSubmit={handleChoice}>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Type</th>
              <th>Price</th>
              <th>Update?</th>
            </tr>
          </thead>
          <tbody>
            {shipping.map((shipping) => (
              <IndivShipping id={shipping.id} type={shipping.type} price={shipping.price} selectedOption={selectedOption} />
            ))}
          </tbody>
        </table>
        <input type="submit" />
      </form>
      <h2>Edit Shipping Term</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Terms:
          <input type="text" name="type" value={inputs.type || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <label>
          Price per Oz: $
          <input type="number" step=".01" name="price" value={inputs.price || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <br></br>
        <input type="submit" />
      </form>
      <p></p>
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}
export default ShippingUpd;

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<AllShipping />);
//          checked={props2.selectedOption === props2.id}
//          onChange={props2.delOthers}

/* async function ShippingChoiceSvc(id) {
  let data = "";
  try {
    const response = await fetch("http://localhost:8081/api2/shipping/" + id, {
      method: "GET",
    });

    if (response.ok) {
      data = await response.json();
      console.log("Success:", data);
    } else {
      console.error("Error:", response.status);
    }
  } catch (error) {
    console.error("Error:", error);
  }
  console.log("Finally:", data);
  return data; ///(<ShippingUpd chosenShipping={data} />);
} */

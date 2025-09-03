import { useState } from "react";
import React from "react";
import ReactDOM from "react-dom/client";
import ShippingSvc from "../shipping-list/ShippingSvc";
import { Link, MemoryRouter, BrowserRouter } from "react-router-dom";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";

function IndivShipping(props2) {
  return (
    <tr>
      <td>{props2.id}</td>
      <td> {props2.type} </td>
      <td> ${props2.price}</td>
    </tr>
  );
}

function ShippingAdd(props) {
  const [inputs, setInputs] = useState({});
  const shipping = props.shipping;

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs((values) => ({ ...values, [name]: value }));
  };

  const handleRouter = () => {
    root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      <BrowserRouter>
        <ShippingRoute2 />
      </BrowserRouter>
    );
  };
  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(inputs);
    try {
      const response = await fetch("http://localhost:8081/api2/shipping", {
        method: "POST",
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
    console.log("about to root render ShippingSvc"); ////////
    root.render(
      <MemoryRouter>
        <ShippingSvc child="ShippingAdd" />
      </MemoryRouter>
    );
    //window.location.reload(); //TODO added to make link work; try to find a cheaper way.  See https://stackoverflow.com/questions/41481522/how-to-refresh-a-page-using-react-route-link
  };

  return (
    <>
      <h1>Shipping Terms</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {shipping.map((shipping) => (
            <IndivShipping id={shipping.id} type={shipping.type} price={shipping.price} />
          ))}
        </tbody>
      </table>
      <p></p>
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
        <input type="submit" />
      </form>
      <p></p>
      {/* <Link to="http://localhost:3000">Back to Home</Link> */}
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<ShippingAdd />);

export default ShippingAdd;

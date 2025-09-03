import React from "react";
import ReactDOM from "react-dom/client";
import "./ShippingList.css";
import { Link } from "react-router-dom";

function IndivShipping(props2) {
  return (
    <tr>
      <td>{props2.id}</td>
      <td> {props2.type} </td>
      <td> ${props2.price}</td>
    </tr>
  );
}

function ShippingList(props) {
  const shipping = props.shipping;
  console.log(shipping); ////////
  const epochToDt = (epoch) => {
    return new Date(epoch * 1000);
  };
  return (
    <>
      <h1>Shipping Terms</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Price per Oz</th>
          </tr>
        </thead>
        <tbody>
          {shipping.map((shipping) => (
            <IndivShipping id={shipping.id} type={shipping.type} price={shipping.price} />
          ))}
        </tbody>
      </table>
      <p></p>
      <Link to="/">Back to Home</Link>
    </>
  );
}

//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(<AllShipping />);

export default ShippingList;
/*  updOn={shipping.updatedOn}       <td> {props2.updOn} </td>              <th>Last Updated</th>
 */

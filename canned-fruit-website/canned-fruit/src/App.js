import React from 'react';
import ReactDOM from 'react-dom/client';
import './App.css';

function Shipping(props) {
  return <tr><td>{props.id}</td><td> { props.type }</td><td> ${props.price}</td></tr>;
}

function Garage() {
  const shipping = [
    {
        "id": 4,
        "type": "Overnight",
        "price": 1.29
    },
    {
        "id": 3,
        "type": "Two to Three Day",
        "price": 0.59
    },
    {
        "id": 2,
        "type": "Five Day",
        "price": 0.39
    },
    {
        "id": 1,
        "type": "One week",
        "price": 0.19
    },
    {
        "id": 52,
        "type": "Two Week",
        "price": 0.0
    }
];
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
        {shipping.map((shipping) => <Shipping id={shipping.id} type={shipping.type} price={shipping.price} />)}
      </tbody>
      </table>
    </>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Garage />);

export default Garage;
import React from "react";
import ReactDOM from "react-dom/client";
import "./CannedFruitList.css";
import CurrencyDisplay from "../utils/CurrencyDisplay";
import { Link, BrowserRouter } from "react-router-dom";
import ShippingRoute2 from "../shipping-route/ShippingRoute2.tsx";

function IndivCannedFruit(props2) {
  //console.log(JSON.stringify(props2)); /////////
  return (
    <tr>
      <td>{props2.id}</td>
      <td> {props2.fruit} </td>
      <td> {props2?.medium?.mediumName}</td>
      <td> {props2.unitType}</td>
      <td> {props2.volume}</td>
      <td> {props2.container}</td>
      <td>
        {" "}
        <CurrencyDisplay amount={props2.pricePer} />
      </td>
    </tr>
  );
}

function epochToDt(epoch) {
  return new Date(epoch * 1000);
}

function CannedFruitList(props) {
  const cannedFruit = props.cannedFruit;
  //const cannedFruit = JSON.parse('[{"id":4,"fruit":"Assorted","medium":{"id":3,"mediumName":"light syrup"},"unitType":"diced","volume":8,"container":"can","pricePer":0.55},{"id":3,"fruit":"grapefruit","medium":{"id":1,"mediumName":"water"},"unitType":"sectioned","volume":16,"container":"glass jar","pricePer":9.33},{"id":2,"fruit":"peach","medium":{"id":3,"mediumName":"light syrup"},"unitType":"sliced","volume":8,"container":"can","pricePer":4.00},{"id":1,"fruit":"pear","medium":{"id":2,"mediumName":"own juices"},"unitType":"sliced","volume":8,"container":"can","pricePer":0.44},{"id":6,"fruit":"pineapple","medium":{"id":1,"mediumName":"water"},"unitType":"chunk","volume":8,"container":"can","pricePer":0.91},{"id":52,"fruit":"pineapple","medium":null,"unitType":"ringed","volume":8,"container":"can","pricePer":0.55}]');
  //console.log(cannedFruit); ///////
  //TODO add sorting links in header    https://stackoverflow.com/questions/60088576/how-to-do-default-sorting-in-react-table
  const handleNavigation = (href) => {
    console.log("🔄 Menu navigation forcing refresh to:", href);
    window.location.href = href;
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
      <h1>Canned Fruit Offerings</h1>
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
      <p></p>
      {/* <Link to="/">Back to Home</Link>
      <p />
      <button type="button" onClick={(e) => handleNavigation("http://localhost:3000/entry")}>
        {" "}
        Logout
      </button> */}
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<AllCannedFruit />);

export default CannedFruitList;

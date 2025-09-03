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
        <input type="radio" name="updRadios" value={props2.id} />{" "}
      </td>
    </tr>
  );
}

function CannedFruitUpd(props) {
  const cannedFruit = props.cannedFruit;
  console.log(cannedFruit); ///////
  const mediums = props.mediums;
  //console.log(chosenCannedFruit); ///////
  const [inputs, setInputs] = useState({});
  const [selectedOption, setSelectedOption] = useState(0);
  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    if (name != "medium") {
      setInputs((values) => ({ ...values, [name]: value }));
    } else {
      setInputs((values) => ({ ...values, [name]: { id: value } }));
    }
  };
  const handleChoice = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    let values = JSON.stringify(Object.fromEntries(formData.entries()));
    let json = JSON.parse(values);
    var data = "";
    try {
      const response = await fetch("http://localhost:8081/api2/cannedFruit/" + json.updRadios, {
        method: "GET",
      });
      if (response.ok) {
        let data = await response.json();
        console.log(data.medium.id); ///////
        setInputs(data);
        setSelectedOption(data.medium.id);
      } else {
        console.error("Error:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };
  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(inputs);
    try {
      const response = await fetch("http://localhost:8081/api2/cannedFruit/" + inputs.id, {
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
        <CannedFruitSvc child="CannedFruitUpd" />
      </MemoryRouter>
    );
    //window.location.reload(); //TODO added to make link work; try to find a cheaper way
  };
  const listItems = mediums.map((medium) =>
    medium.id === selectedOption ? (
      <option value={medium.id} selected>
        {medium.mediumName}
      </option>
    ) : (
      <option value={medium.id}>{medium.mediumName}</option>
    )
  );
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
      <h1>Update a Canned Fruit Offering</h1>
      <h2>Select a Canned Fruit Offering</h2>
      <form onSubmit={handleChoice}>
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
              <th>Upd?</th>
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
                selectedOption={selectedOption}
              />
            ))}
          </tbody>
        </table>
        <input type="submit" />
      </form>
      <h2>Edit CannedFruit</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Fruit:
          <input type="text" name="fruit" value={inputs.fruit || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <label>
          Medium:
          <select name="medium" onChange={handleChange}>
            <option value="0">-Select-</option>
            {listItems}
          </select>
          &nbsp;
        </label>
        <label>
          Preparation:
          <input type="text" name="unitType" value={inputs.unitType || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <label>
          Volume in Oz:
          <input type="number" step="4" name="volume" value={inputs.volume || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <p />
        <label>
          Container:
          <input type="text" name="container" value={inputs.container || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <label>
          Price per Oz: $
          <input type="number" step=".01" name="pricePer" value={inputs.pricePer || ""} onChange={handleChange} />
          &nbsp;
        </label>
        <p />
        <input type="submit" />
      </form>
      <p></p>
      <button onClick={handleRouter}>Back to Menu</button>
    </>
  );
}
export default CannedFruitUpd;

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<AllCannedFruit />);
//          checked={props2.selectedOption === props2.id}
//          onChange={props2.delOthers}

/* async function CannedFruitChoiceSvc(id) {
  let data = "";
  try {
    const response = await fetch("http://localhost:8081/api2/cannedFruit/" + id, {
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
  return data; ///(<CannedFruitUpd chosenCannedFruit={data} />);
} */

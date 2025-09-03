import { useState } from "react";
import React from "react";
import ReactDOM from "react-dom/client";
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
    </tr>
  );
}
function GenOption(medium) {
  return <option value="{medium.id}">{medium.mediumName}</option>;
}

function CannedFruitAdd(props) {
  const [inputs, setInputs] = useState({});
  //console.log(props.cannedFruit);
  const cannedFruit = props.cannedFruit;
  const mediums = props.mediums;
  //const mediumsRendered = mediums.map((medium) => "<option value=\"{medium.id}\">{medium.mediumName}</option>");

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    if (name != "medium") {
      setInputs((values) => ({ ...values, [name]: value }));
    } else {
      if (value === "0") {
        alert("Select a medium");
      } else {
        setInputs((values) => ({ ...values, [name]: { id: value } }));
      }
    }
    console.log(inputs); ///////
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(inputs);
    if (inputs.medium == null) {
      alert("Select a Medium");
      return;
    }
    try {
      const response = await fetch("http://localhost:8081/api2/cannedFruit", {
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
    root.render(
      <MemoryRouter>
        <CannedFruitSvc child="CannedFruitAdd" />
      </MemoryRouter>
    );
    //window.location.reload();  //TODO added to make link work; try to find a cheaper way
  };
  /* TODO find a way to have a -Select- option but force users to select something */
  const listItems = mediums.map((medium) => <option value={medium.id}>{medium.mediumName}</option>);
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
      <h1>Add a Canned Fruit Offering</h1>
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
      <form onSubmit={handleSubmit}>
        <label>
          Fruit:
          <input type="text" name="fruit" value={inputs.fruit || ""} onChange={handleChange} required />
          &nbsp;
        </label>
        <label>
          Medium:
          <select name="medium" onChange={handleChange} required>
            <option value="0">-Select-</option>
            {listItems}
          </select>
          &nbsp;
        </label>
        <label>
          Preparation:
          <input type="text" name="unitType" value={inputs.unitType || ""} onChange={handleChange} required />
          &nbsp;
        </label>
        <label>
          Volume in Oz:
          <input type="number" step="4" name="volume" value={inputs.volume || ""} onChange={handleChange} required />
          &nbsp;
        </label>
        <p />
        <label>
          Container:
          <input type="text" name="container" value={inputs.container || ""} onChange={handleChange} required />
          &nbsp;
        </label>
        <label>
          Price per Oz: $
          <input type="number" step=".01" name="pricePer" value={inputs.pricePer || ""} onChange={handleChange} required />
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

var root = ReactDOM.createRoot(document.getElementById("root"));
//root.render(<CannedFruitAdd />);
//            {mediums.map((mediums) => (<GenOption medium={mediums} />))}

export default CannedFruitAdd;

/*    medium.mediumName === "own juices" ? (
  <option value={medium.id} selected>
    {medium.mediumName}
  </option>
) : (*/

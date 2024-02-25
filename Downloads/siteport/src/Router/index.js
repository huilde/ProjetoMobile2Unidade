import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Site from "../Components/site";
const RouterDOM = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/">
          <Site />
        </Route>
      </Switch>
    </Router>
  );
};
export default RouterDOM;

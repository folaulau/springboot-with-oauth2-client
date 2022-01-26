import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { Router, Route, Switch } from "react-router-dom";
import { createBrowserHistory } from "history";
import Home from './home';
import SignIn from './signin';
import SignUp from './signup';
import Auth from './auth';
import 'bootstrap/dist/css/bootstrap.min.css';
import PrivateRoute from './components/private-route';

const history = createBrowserHistory();

const rootElement = document.getElementById('root');

ReactDOM.render(
  <React.StrictMode>
    <Router history={history}>
      {/* Switch will render the first component that matches the route frist */}
      <Switch>
        <PrivateRoute component={Home} path="/" exact />
        <Route exact path="/auth">
            <Auth />
        </Route>
        <Route exact path="/signin">
            <SignIn />
        </Route>
        <Route exact path="/signup">
            <SignUp />
        </Route>
      </Switch>
    </Router>
  </React.StrictMode>,
  rootElement
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

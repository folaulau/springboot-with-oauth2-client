import logo from './logo.svg';
import './App.css';
import React, { useEffect } from 'react';
import {
  useLocation
} from "react-router-dom";
import UserApi from './api/UserApi';
import AuthService from './utils/auth';
import { useHistory } from "react-router-dom";

function useQuery() {
  const { search } = useLocation();

  return React.useMemo(() => new URLSearchParams(search), [search]);
}
function Auth() {

  const history = useHistory();
  const query = useQuery();

  useEffect(() => {
    // Update the document title using the browser API
    document.title = "Auth - oAuth2";

    let code = query.get("code");

    console.log("code: " + code)

    signUpWithGithub(code);

  }, []);// eslint-disable-line react-hooks/exhaustive-deps

  const signUpWithGithub = (code) => {
    console.log("code: " + code);

    UserApi.signUp({ "clientType": "GITHUB", "token": code })

      .then(response => {
        console.log("response");
        console.log(response.data);
        let session = response.data;


        AuthService.startSession(session);

        //history.push("/");

      }).catch(apiError => {
        console.log("error");
        console.log(apiError);

      });
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        Auth
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default Auth;

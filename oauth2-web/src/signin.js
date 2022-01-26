import './App.css';
import React, { useState, useEffect } from 'react';
import { Form, Row, Col } from 'react-bootstrap';

function SignIn() {

  const [user, setUser] = useState({ "clientType": "", "token": "", "email": "", "firstName": "", "lastName": "", "password": "" });

  useEffect(() => {
    // Update the document title using the browser API
    document.title = "Sign In - oAuth2";
  });

  const handleInputChange = (event) => {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;
    console.log("handleInputChange");
    console.log("name: " + name);
    console.log("value: " + value);
    setUser({ ...user, [name]: value });
  }

  const signIn = (event) => {
    event.preventDefault();

  }

  return (
    <Row>
      <Col xs={12} sm={12} className="mt-5">
        <Row className="mt-3">
          <Col xs={{ span: 10, offset: 1 }} sm={{ span: 6, offset: 3 }} className="shadow p-3 mb-5 bg-body rounded">
            <Row>
              <Col xs={12} className="text-center">
                <h2>Sign In</h2>
              </Col>
            </Row>
            <Row>
              <Col xs={6} className="d-grid gap-2">
                <a href='https://github.com/login/oauth/authorize?client_id=86222ffc9bfa18282854&scope=user&redirect_uri=http://localhost:3000/auth?action=signin&clientType=GITHUB' className="btn btn-lg btn-primary">Github</a>
              </Col>
              <Col xs={6} className="d-grid gap-2">
                <a href='/oauth2/authorization/google' className="btn btn-lg btn-primary">Google</a>
              </Col>
            </Row>
            <Row className="mb-3">
              <Col xs={12} className="text-center">
                or
              </Col>
            </Row>
            <Form>
              <Row className="mb-3">
                <Col xs={12}>
                  <div className="form-floating">
                    <input type="email" className="form-control"
                      name="email"
                      onChange={handleInputChange}
                      value={user.email}
                      placeholder="john@gmail.com" />
                    <label>Email Address</label>
                  </div>
                </Col>
              </Row>
              <Row className="mb-3">
                <Col xs={12}>
                  <div className="form-floating">
                    <input type="password" className="form-control"
                      name="password"
                      onChange={handleInputChange}
                      value={user.password}
                      placeholder="password" />
                    <label>Password</label>
                  </div>
                </Col>
              </Row>
              <Row className="mb-3">
                <Col xs={12} className="d-grid gap-2">
                  <button className="btn btn-lg btn-primary" type="button" onClick={signIn}>Sign In</button>
                </Col>
              </Row>
              <Row className="mt-2">
                <Col xs={12}>
                  <a href='/signup'>You don't have an account yet?</a>
                </Col>
              </Row>
            </Form>
          </Col>
        </Row>
      </Col>
    </Row>
  );
}

export default SignIn;

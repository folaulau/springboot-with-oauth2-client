import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import AuthService from '../utils/auth';

const PrivateRoute = ({component: Component, ...rest}) => {
    return (

        // Show the component only when the user is logged in
        // Otherwise, redirect the user to /signin page
        <Route {...rest} render={props => (
            AuthService.isLoggedIn() ?
                <Component {...props} />
            : <Redirect to="/signin" />
        )} />
    );
};

export default PrivateRoute;
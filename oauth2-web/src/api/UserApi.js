import axios from 'axios';
import Base64 from 'base-64';

var instance = axios.create({
    baseURL: "http://localhost:8888"
});

const UserApi = {

    pingServer: () => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'x-api-key': 'web-api-key'
            }
        };
        return instance.get('/ping', options);
    },
    signUp: (data) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'x-api-key': 'web-api-key'
            }
        };
        return instance.post('/users/signup', JSON.stringify(data), options);
    },
    signIn: (email, password) => {

        const emailAndPassword = email + ':' + password;
        const hash = Base64.encode(emailAndPassword);
        const authenticationToken = 'Basic ' + hash;

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'x-api-key': 'web-api-key',
                'Authorization': authenticationToken
            }
        };
        let response = instance.post('/users/signin?type=user', null, options);
        return response;
    },
    requestPasswordReset: (data) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'x-api-key': 'web-api-key'
            }
        };
        return instance.post('/users/request-password-reset', JSON.stringify(data), options);
    },
    passwordReset: (data) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'x-api-key': 'web-api-key'
            }
        };
        return instance.put('/users/password-reset', JSON.stringify(data), options);
    },
    signOut: () => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem("token")
            }
        };
        return instance.delete('/users/signout', options);
    },
    updateProfile: (user) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem("token")
            }
        };
        return instance.put('/users/profile', JSON.stringify(user), options);
    },
    updatePassword: (passwordObj) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem("token")
            }
        };
        return instance.put('/users/password', JSON.stringify(passwordObj), options);
    }, 
    addNewUser: (data) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem("token")
            }
        };
        return instance.post('/users/add', JSON.stringify(data), options);
    },   
    removeUser: (uuid) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem("token")
            }
        };
        return instance.delete('/users/remove?uuid='+uuid, options);
    },
    updateUser: (user) => {

        const options = {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem("token")
            }
        };
        return instance.put('/users/student', JSON.stringify(user), options);
    }
}

export default UserApi;
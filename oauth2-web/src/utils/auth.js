
const AuthService = {

    startSession: (session) => {
        localStorage.setItem("token", session.token);
        localStorage.setItem("uuid", session.uuid);
        localStorage.setItem("email", session.email);
    },
    isLoggedIn: () => {
        if (localStorage.getItem("token") != null && localStorage.getItem("token").length > 0) {
            return true;
        } else {
            return false;
        }
    },
    endSession: () => {
        localStorage.clear();
    }
}

export default AuthService;
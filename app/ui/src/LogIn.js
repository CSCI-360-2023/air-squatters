import { useNavigate } from "react-router-dom";

function LogIn() {

  const navigate = useNavigate();
  const userData = []

  

    return (
      <div class="center">
        <h2>Log In To Ticketing System</h2>
        <div>
          Username:&nbsp;
          <input type="text" name="Username" placeholder="Enter Username"></input>
          <br/>
          Password:&nbsp;&nbsp;
          <input type="password" name="Password" placeholder="Enter Password"></input>
        </div>
        <br/>
        <button onClick={() => {navigate('/main')}}>Log In</button>
        <br/>
        <button onClick={() => {navigate('/signup')}}>   Sign Up</button>
      </div>
    );
}
// NEED TO GET THE DATA FROM HERE AND PUSH IT TO THE DATABASE
export default LogIn;
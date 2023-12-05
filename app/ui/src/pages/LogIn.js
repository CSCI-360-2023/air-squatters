function LogInPage() {
  const responseMessage = (response) => {
    console.log(response);
  };
const errorMessage = (error) => {
    console.log(error);
  };
return (
    <div>
      <div className='card'>
        <h1 class="center" >Log In</h1>
        <br />
        <br />
        <GoogleLogin onSuccess={responseMessage} onError={errorMessage} />
      </div>
    </div>
  )
      /*<div className='card'>
        <h1 class="center" >Log In</h1>
        <div class="center">Username:
          <input type="number" placeholder="Enter your CofC ID" readonly></input>
        </div>
        <div class="center">Password:
          <input type="password" placeholder="Enter your Password" readonly></input>
        </div>
        <div class="center">
          <button>Log In</button>
        </div>
        <div class="center">
          <button>Sign Up</button>
        </div>
      </div>
    ); */
  }
  
  export default LogInPage;
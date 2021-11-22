import React, { useState } from 'react';
import { Button} from 'react-bootstrap';
import { Redirect, useHistory } from 'react-router';

function Logout() {
 

    const [navigate, setNavigate] = useState();

    const logout = () =>{
        sessionStorage.clear();
        sessionStorage.removeItem("token");
        setNavigate({navigate:true});
        window.location.href = "/";
         
    }
  
    if(navigate){
        return <Redirect to="/" push={true} />;
    }  

      return(
        <Button variant="secondary" onClick = {logout}>Log out</Button> 
      );
}

export default Logout;
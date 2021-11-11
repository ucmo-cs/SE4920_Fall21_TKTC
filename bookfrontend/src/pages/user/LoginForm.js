import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { Redirect } from 'react-router';
import { BrowserRouter,useHistory } from 'react-router-dom';
 

function LoginForm({setToken}) {

  let history = useHistory();

  const LoginSubmit =(e) =>{
    e.preventDefault();
    history.push('/covid')
        
  }

  const [name, setUserName] = useState();
  const [password, setPassword] = useState();  

  const handleSubmit = (e) => {
    //e.preventDefault();
    const user = { name, password };
    
    fetch('http://localhost:8080/jpa/login', {
   
      method: 'POST',
      headers: { 
        'Content-Type': 'application/json',
        'Accept': 'application/json' },
      body: JSON.stringify(user),
      credentials : 'same-origin',
      }).then((res) => {
        console.log(res)     
        return res.json(); 
      }).then((res) =>{
        console.log(res);
        setToken(res);
      });

  }


  return (
<Form onSubmit = {handleSubmit}> 
  <Form.Group className="mb-3" controlId="formBasicEmail">
    <Form.Label>Username</Form.Label>
    <Form.Control type="text" placeholder="Username" onChange = {(e)=> setUserName(e.target.value)}/>
    <Form.Text className="text-muted">
      Username and Password are Confidential and Private
    </Form.Text>
  </Form.Group>

  <Form.Group className="mb-3" controlId="formBasicPassword">
    <Form.Label>Password</Form.Label>
    <Form.Control type="password" placeholder="Password" onChange = {(e)=> setPassword(e.target.value)}/>
  </Form.Group>

  <Form.Group className="mb-3" controlId="formBasicCheckbox">
    <Form.Check type="checkbox" label="Check me out" />
  </Form.Group>
  <Button variant="primary" type="submit">
    Login
  </Button>
</Form>
  );
}

export default LoginForm;

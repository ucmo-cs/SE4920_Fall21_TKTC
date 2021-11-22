import React from 'react';
import { Form, Button } from 'react-bootstrap';
import { Redirect } from 'react-router';
import { BrowserRouter,useHistory } from 'react-router-dom';
 

function LoginForm(props) {

  let history = useHistory();

  const LoginSubmit =(e) =>{
    e.preventDefault();
    history.push('/covid')
        
  }


  return (
<Form onSubmit = {LoginSubmit}> 
  <Form.Group className="mb-3" controlId="formBasicEmail">
    <Form.Label>Username</Form.Label>
    <Form.Control type="email" placeholder="Username" />
    <Form.Text className="text-muted">
      Username and Password are Confidintual and Private
    </Form.Text>
  </Form.Group>

  <Form.Group className="mb-3" controlId="formBasicPassword">
    <Form.Label>Password</Form.Label>
    <Form.Control type="password" placeholder="Password" />
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

import react, { useState } from 'react';
import { Button, Container, Nav, Navbar } from 'react-bootstrap';
import {Link} from 'react-router-dom';
 
function App() {

  const [loginStatus, setLogin] = useState('N')

  return (
<>
  <Navbar bg="dark" variant="dark">
    <Container>
    
    <Link to ="/" className = "navbar-brand">KC Federal</Link>

    <Nav className="me-auto">
      <Link to ="/calendar" className = "nav-link">Calendar</Link>
      <Link to ="/edit" className = "nav-link">Bank Guidance</Link>
      <Link to ="/covid" className = "nav-link">Covid Guidance</Link>  
      <Link to ="/login" className = "nav-link">Login</Link>
    
    </Nav>
    </Container>
  </Navbar>
  <br />
 
 
</>
  );
}

export default App;


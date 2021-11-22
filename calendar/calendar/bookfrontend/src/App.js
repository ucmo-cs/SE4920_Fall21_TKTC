import logo from './logo.svg';
import './App.css';
import {Container} from 'react-bootstrap';
import {Route} from 'react-router-dom';
import Header from './components/Header'
import SaveForm from './pages/user/SaveForm';
import Home from './pages/book/Home';
import LoginForm from './pages/user/LoginForm';
import JoinForm from './pages/user/JoinForm';
import UpdateForm from './pages/user/UpdateForm';
import Detail from './pages/book/Detail';
import EditForm from './pages/user/EditForm';
import CovidForm from './pages/user/CovidForm';
import CalendarForm from './pages/user/CalendarForm';

function App() {
  return (
    <div>
      <Header/>
      <Container>
        <Route path="/" exact={true} component={Home}/>
        <Route path="/edit" exact={true} component={EditForm}/>
        <Route path="/covid" exact={true} component={CovidForm}/>
        <Route path="/login" exact={true} component={LoginForm}/>
        <Route path="/calendar" exact={true} component={CalendarForm}/>
        <Route path="/update/:id" exact={true} component={UpdateForm}/>
      </Container> 
    </div>   
  );
}

export default App;

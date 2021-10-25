import './App.css';
import button from './components/testButton';
import AppBar from './components/Appbar';
import User from './components/User';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>Hello world!</p>
        <AppBar/>
        <User/>
      </header>
    </div>
  );
}

export default App;

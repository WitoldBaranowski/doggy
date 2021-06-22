import './App.css';
import axios from 'axios'
import {BrowserRouter as Router, Route} from 'react-router-dom'
import SignIn from './sign';
import React,{useState} from 'react'
import Main from './MainSite'

function App() {
  const[login, setlogin]=useState(false)
  const[postId, setPostId]=useState()
  return (<Router>
    <SignIn setlogin = {setlogin} setPostId = {setPostId}/>
    {login && <h1>{postId}</h1>}
    <Route path='/MainSite' component = {Main}/>
  </Router>
  );
}

export default App;

import './App.css';
import axios from 'axios'
import {BrowserRouter as Router, Route} from 'react-router-dom'
import SignIn from './sign';
import React,{useState} from 'react'
import Main from './MainSite'

function App() {
  const[login, setlogin]=useState(false)
  const[postId, setPostId]=useState()
  
  if(!login)
  {
    return (
    <>
    <SignIn setlogin = {setlogin} setPostId = {setPostId}/>
    {login && <h1>{postId}</h1>}
  </>);
  }else {
    return (
    <>
    Main
 </>
  
    );
    }
}

export default App;

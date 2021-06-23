import './App.css';
import axios from 'axios'
import {BrowserRouter as Router, Route} from 'react-router-dom'
import SignIn from './sign';
import React,{useState} from 'react'
import SignUp from './sign_up';
import Forum from './main forum/Forum';

function App() {
  const[login, setlogin]=useState(false)
  const[postId, setPostId]=useState()
  const[signup, setsignup] = useState(false)
  const[usernam, setUsernam] = useState('')
  if(!login&&!signup)
  {
    return (
      <>
        <SignIn setlogin = {setlogin} setPostId = {setPostId} setsignup = {setsignup} setUsernam = {setUsernam}/>
      {login && <h1>{postId}</h1>}
      </>
    );
  }
  if(login) {
    return (
      <>
      <Forum usernam = {usernam}/>
      </>
    );
  }
  if(signup)
  {
    return (
      <>
      <SignUp setlogin = {setlogin} setsignup = {setsignup}/>
      </>
    );
  }
}

export default App;

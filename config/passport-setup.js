const passport = require('passport')
const localStrategy = require('passport-local').Strategy
const User = require('../models/User')

passport.serializeUser(function(user, done) {
    done(null, user.id);
});

 passport.deserializeUser(function(id, done) {
    User.findById(id, function(err, user) {
        done(err, user);
    });
});
//register user
passport.use('local.signup', new localStrategy({

    usernameField: 'email',
    passwordField: 'password',
    passReqToCallback: true
},(req,username,password, done) => {
   if(req.body.password != req.body.confirm_password) {
    return done(null, false, req.flash('error', 'Passwords do not match'));
   }else{
    User.findOne({email:username}, (err, user) => {
        if(err) {
            return done(err);
        }
        if(user) {
            return done(null, false, req.flash('error', 'Email is already in use'));
        } if(!user){
            //create user
          let newUser = new User()
          newUser.email = req.body.email
          newUser.password =  newUser.hashPassword(req.body.password),
          newUser.avatar = "profile.png"
          newUser.save ((err,user) => {
            if(!err) {
                return done(null, user, req.flash('success', 'User Added'));
            }else{
                console.log(err)

            }
          })

        }
    })
   }
}))
//login Strategy
passport.use('local.login', new localStrategy({
    usernameField: 'email',
    passwordField: 'password',
    passReqToCallback: true
}, (req, username, password, done)=>{
    User.findOne({email:username}, (err, user) => {
    if(err){
        return done(null, false, req.flash('error', 'Something wrong happened'));
    }
    if(!user){
        return done(null, false, req.flash('error', 'User not found'));
    }
    if(user){
        if(user.comparePassword(password, user.password)){
            return done(null, user, req.flash('success', 'Welcome Back'))
        }
        else{
            return done(null, false, req.flash('error', 'Password is incorrect'));
        }
    } 
   })
}))
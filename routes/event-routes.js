const express = require("express")
const router = express.Router()
const Event = require('../models/Event')
//validate input
const {check , validationResult} = require('express-validator/check')
// date and time
const moment = require('moment');
moment().format();

//middleware to check if user is logged in

isAuthenticated = (req,res,next) => {
    if(req.isAuthenticated()) return next();
    res.redirect('/users/login')
}

//create new events

router.get('/create' , isAuthenticated, (req,res)=>{
  res.render('events/create', {
    errors : req.flash('errors')
  })    
  //route to home events
  router.get('/:pageNo?', (req,res)=>{
    let pageNo = 1

    if( req.params.pageNo){
        pageNo = parseInt(req.params.pageNo)
    }
    if(req.params.pageNo == 0 ) {
      pageNo = 1
    }
    let q = {
        skip: 5 * (pageNo - 1),
        limit: 5
    }
    //find total documents
    let totalDocs = 0

    Event.countDocuments({} , (err,total)=>{

    }).then((response)=>{
        totalDocs = parseInt(response)
        Event.find({},{},q, (err,events)=>{
            let chunk = []
            let chunkSize = 3
            for(let i = 0; i < events.length; i+=chunkSize) {
                chunk.push(events.slice(i,i+chunkSize))
            }
            res.render('events/index', {
                chunk : chunk,
                message : req.flash('info'),
                total : parseInt(totalDocs),
                pageNo : pageNo,
            })
        })
    })
  })
})
//save event to DB

router.post('/create', [
    check('title').isLength({min: 5}).withMessage('Title should be more than 5 char'),
    check('description').isLength({min: 5}).withMessage('Description should be more than 5 char'),
    check('location').isLength({min: 3}).withMessage('Shelf# should be more than 3 char'),
    check('date').isLength({min: 5}).withMessage('Date should be valid Date'),
], (req,res)=> {
    const errors = validationResult(req)
    if(!errors.isEmpty()){
        req.flash('errors', errors.array())
        return res.redirect('/events/create')
    }else{
     let newEvent = new Event({
        title : req.body.title,
        description : req.body.description,
        location : req.body.location,
        date : req.body.date,
        user_id: req.body.id,
        created_at : Date.now()
     })
     newEvent.save((err)=>{
        if(!err){
           console.log('Book was added')
           req.flash('info', 'The Book was created successfully')
           res.redirect('/events')
        }else{
            console.log(err)
        }
    })
   }
})
router.get('/show/:id' , (req,res)=>{
    Event.findOne({_id : req.params.id}, (err,event)=>{
    if(!err){
        res.render('/event/show', {
            event: event
        })
        }else{
            console.log(err)
        }
    })
})
//edit route
router.get('/edit/:id', isAuthenticated , (req,res)=>{
    Event.findOne({_id : req.params.id}, (err, event)=>{
        if(!err){
            res.render('events/edit', {
                event : event,
                eventDate : moment(event.date).format('YYYY-MM-DD'),
                errors: req.flash('errors'),
                message: req.flash('info')
            })
        }else{
            console.log(err)
        }
    })
})
//update form
router.post('/update', [
    check('title').isLength({min: 5}).withMessage('Title should be more than 5 char'),
    check('description').isLength({min: 5}).withMessage('Description should be more than 5 char'),
    check('location').isLength({min: 3}).withMessage('Shelf# should be more than 3 char'),
    check('date').isLength({min: 5}).withMessage('Date should be valid Date'),
], isAuthenticated, (req,res) => {
    const errors = validationResult(req)
    if(!errors.isEmpty()){
        req.flash('errors', errors.array())
        return res.redirect('/events/edit/ '+req.body.id)
    }else{
        //create obj
        let newfields = {
            title : req.body.title,
            description : req.body.description,
            location : req.body.location,
            date : req.body.date
        }
        let query = {_id: req.body.id}
        Event.updateOne(query, newfields, (err)=>{
            if(!err) {
                req.flash('info', 'The Book was updated successfully')
                res.redirect('/events')
            }else{
                console.log(err)
            }
        })
    }
})
//delete event
router.delete('/delete/:id', isAuthenticated, (req, res)=>{
    let query = {_id: req.params.id}
    Event.deleteOne(query, (err)=>{
        if(!err){
            res.status(200).json('deleted')
        }else{
            res.status(404).json('There was an error. Book was not deleted')
        }
    })
})
module.exports = router
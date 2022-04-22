# Kiang_Ryan_Run_With_It_CaseStudy

- [Daily Progress](#Daily-Progress)
- [User Stories](#User-Stories)
  - [Admin Stories](#Admin-Stories)
  - [Stretch Goals](#Stretch-Goals)
- [Database Schema](References/dbschema.png)
- [Technical Architecture](References/technical_architecture.png)
- [Technical Challenges](#Technical-Challeneges)
- [Lessons Learned](#Lessons-Learned)
- [Wireframes](References/Kiang_Ryan_Wireframe.pdf)
- [Jira](https://rkiang.atlassian.net/jira/software/projects/RUN/boards/1) (External Site)
  - Please contatct [Ryan Kiang](mailto:ryanlkiang@gmail.com) to access this Jira account.
- [Case Study Rubics](https://docs.google.com/document/d/1xvXC5AlyGPZDn9rpW9A-ZB7KM-tPEX3E_AEppKxE8xk/edit) (External Site)
  - Please contatct [Ryan Kiang](mailto:ryanlkiang@gmail.com) to access this Google Document.

### Application will be a fitness tracking utility application.

# Contents:
## Daily Progress
- **April 22nd (85-90% complete)
  - Added user account page, access only from profile page.
  - More Junit testing was done.
  - Error pages were re-added.
  - Need to fix user account update from deleting join table.
  - Need to finish custom queries.
- **April 21st (80-85% complete)
  - Added final model, all CRUD operations are working.
  - Working on test units.
  - Will still need to add custom queries.
- **April 20th (80-85% complete)**
  - Able to update and delete on controllers.
  - Cannot update successfully for user account yet.
  - Need to do custom queries next.
- **April 19th (80% complete)**
  - Landing page works as intended.
  - Goals are posting correctly with logged in user's id in joined table.
  - Goals are also displaying for only the logged in user.
- **April 18th (75% complete)**
  - **Landing page will need remapping, to start, go to /login** 
  - Corrected issue with logging into account and registration.
  - Adding goal functionality with dates.
- **April 15th (70% complete)**
  - Working on fixing login
  - Likely scaling down to remove Exercise logic and implement to workouts and goals each.
- **April 14th (70% complete)**
  - Completed registration with login.
  - Added last model, working on many and one to many table joins.
  - Working with posting with logged in user.
- **April 13th (60% complete)**
  - Added user registration
- **April 12th (50% complete)** 
  - Adding User Goals CRUD and views, then registration.
  - After that, last remaining large component will be the Workout CRUD.
- **April 11th (50% complete)**
  - Half of the pages are complete, as well as half of the models. 
  - About 50% complete with application MVP. 
  - A lot of the user stories below are smaller implementations.
  - Overall picture is clearer and coding is easier as I continue.

## User stories:
- <strike>As a user, I want to create and login into a personal account, so I can keep records of my fitness routine.</strike>
- As a user, I want to select which day of the week, so I may add/edit information about my workouts.
- As a user, I want to create goals to work towards, so I can view the progress over time.
- As a user, I want to add duration to cardio exercises, so I may view length of time my workouts last.
- As a user, I want to add weight lifting exercises, so I may add reps/sets for each exercise.
- As a user, I want to view and submit to a community board/page, so I may read about other users' tips and types of exercises.
- As a user, I want to be able to rate other user's tips and exercise inputs, so I may submit my opinion. 
- As a user, I want to add/edit/delete body weight submissions, so I may keep a log of my weight goals.
- As a user, I want to add community exercises, so I may quickly add them to my goal or past workouts.
- As a user, I want to mark goals 'Complete' when achieved, so I can remove the goal as inactive.
- As a user, I want to edit goals, so I can change parameters if they were initially not ideal.
- <strike>As a user, I want to have a cancel/confirm button before submission, so I don't have to delete/edit the submission afterwards.</strike>
- As a user, I want to name/rename my goals, so I can understand my own submissions to my liking.
- <strike>As a user, I want to create and add custom personal exercise types, so I do not have to add through a community page.</strike>
- <strike>As a user, I want a menu on each view, so I may quickly access other pages and a logout button to securely exit the application session.</strike>

## Admin Stories
- As an Admin user, I want to be able to remove/delete posts in community page, so I can keep the page maintained and less cluttered.
- As an Admin user, I want to view and modify users' account access rights, so I may create "moderator" accounts to manage the community page.
- As a moderator user, I want edit options on the community page, so I may maintain the page.

## Stretch Goals
- [Stretch Goal] As a user, I want to view a community page with rating system and sort by too, so I may look at top-rated submissions over time.
- [Stretch Goal] As a user, I want a personal account page, so I may edit my username and/or password credentials.
- [Stretch Goal] As a user, I want to use Google Account, so I can log in without create a new account and use my existing Google account.
- [Stretch Goal] As a user, I want to export workout days to create events in my Google Calendar, so I may have my schedule with my workout plan.

## Technical Architecture
- Java, JPA
- MySQL
- JavaScript, Bootstrap

## Technical Challenges
- Creating custom user registration and login.

## Lessons Learned
- Project management, therefore I can complete tasks in easier and more manageable items
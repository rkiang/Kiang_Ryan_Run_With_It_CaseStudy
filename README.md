# Kiang_Ryan_Run_With_It_CaseStudy

- [Daily Progress](#Daily-Progress)
- [User Stories](User-Stories)
  - [Admin Stories](Admin-Stories)
  - [Stretch Goals](Stretch-Goals)
- [Database tables](DB-Tables)
- [Jira](https://rkiang.atlassian.net/jira/software/projects/RUN/boards/1) 
  - Please contatct [Ryan Kiang](mailto:ryanlkiang@gmail.com) to access this Jira account.

## Daily Progress
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


### Application will be a fitness tracking utility application.

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


## DB Tables
#### User Account Table
| userId<br/>Integer | userName<br/>String | password<br/>String | accessLevel<br/>String |
|--------------------|---------------------|---------------------|------------------------|
| 1                  | appOwner            | #hash               | admin                  |
| 2                  | moderator           | #hash               | moderator              |
| 3                  | user1               | #hash               | basic                  |

#### User's personal exercise page
| userId | exerciseName<br/>String | exerciseType<br/>String | completionStatus<br/>boolean | sets<br/>Integer | reps<br/>Integer | duration<br/>Integer | sharedStatus<br/>String | goalSet<br/>Timestamp |
|--------|-------------------------|-------------------------|------------------------------|------------------|------------------|----------------------|-------------------------|-----------------------|
| 1      | squats                  | Weights                 | false                        | 3                | 8                | null                 | no                      | 01-02-2022            |
| 3      | leg press               | Weights                 | true                         | 5                | 8                | null                 | yes                     | 12-21-2021            |
| 1      | running                 | Cardio                  | false                        | null             | null             | 40                   | yes                     | 02-03-2022            |


### Community Exercises' Table
| exerciseId<br/>Integer | exerciseName<br/>String | exerciseType<br/>String |
|------------------------|-------------------------|-------------------------|
| 1                      | deadlift                | weights                 | 
| 2                      | leg press               | weights                 | 
| 3                      | biking                  | cardio                  | 

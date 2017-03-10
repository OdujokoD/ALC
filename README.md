# ALC #

This is supposed to be a challenge., however it can be used by beginners to get a feel of building a basic android application

## Challenge

Build an Android app to retrieve a list of Java Developers in Lagos using the [Github API](https://developer.github.com/v3/search/#search-users)
* Display the list of developers on a list. Each item on the list should have:
	* User’s profile image
	* User’s GitHub username
* Clicking each item on the list should show their profile details.
* The profile screen should contain:
	* Username
	* Profile photo
	* Github profile URL
	* Button to share their profile, and it should launch a share intent and the content of the share should be “Check out this awesome developer @**github username**, **github profile url**.”
	* Clicking on the Github url should launch the browser and link to their Github page.


## Introduction

When developing, I prefer to follow these steps:
* Create my mockups/sketches
* If database is required, I will plan out the design of the database
* Breakdown the problem into small chunks
* Check if there is a *good* library to handle tasks else plan the implementation of the task
* Get the hands dirty

The reason for following these steps comes from experience on several projects (both android and non-android projets). First, it reduces the implementation time drastically. Second, it helps to keep track of progress on the project.


## Mockups
<p align="center">
  <img src="https://github.com/OdujokoD/ALC/blob/master/mockups/interface_1.jpg" width="350"/>
  <img src="https://github.com/OdujokoD/ALC/blob/master/mockups/interface_2.jpg" width="350"/>
  
<div>Icons made by <a href="http://www.flaticon.com/authors/gregor-cresnar" title="Gregor Cresnar">Gregor Cresnar</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
</p>

## Problem Breakdown
From the challenge/problem specification we can see that the major task is to consume an API and then display the result in a decent manner. This a technical/high level overview of the problem. However, from this we can then break down the problem into chunks or tasks as follows:

1. Make an HTTP connection to the API
2. Parse result from the HTTP connection
3. Display the result(list of developers in Lagos) in a [list](https://developer.android.com/training/material/lists-cards.html)
4. Handle the click event of list item
5. Display detail of the selected developer
6. Add click listener to developer's url link such that it opens up in a web browser
7. Add a share button and handle events also
8. Tidy up

From the list created above, you tend to create a path for your development. Progress can be measured easily when combined with the mockups above.

## Any Library?
**Of course**. When developing, the first problem faced by most programmers is the thought of wanting to write everything from scratch. *Don't reinvent the wheel!*. Leverage when possible. However, you need to choose your libraries wisely (Check out the stars, opened and closed issue, etc.). You can then learn from the library later when you've gotten a good grasp of developing.

With regards to the list of problems, the following libraries were used:
* [Retrofit](http://square.github.io/retrofit/): This can be used for your HTTP connections. This library will really ease your stress for your network connections.
* [Gson](https://github.com/google/gson): Want to have fun parsing your JSON? This is the way forward.
* [Picasso](http://square.github.io/picasso/): This helps to handle your images well. Talk about downloading, transformations and caching, this is what you definitely want to use.
* Others come built in with android, mainly the [support library](https://developer.android.com/topic/libraries/support-library/features.html).

## Get the hands dirty
This is where creativity comes in. At this point, you already have a repertoire of tools at your disposal. Develop to your taste but in the righ manner. Have a good folder structure and follow a coding architecture which suits your style. These two architectures have captured my attention, I am yet to take a dive into any. They are [MVVM](https://upday.github.io/blog/model-view-viewmodel/) and [Clean Architecture](https://medium.com/@dmilicic/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029#.7m0sa8w3y). Feel free to check them out and check for others too.

## Screenshots
<p align="center">
  <img src="https://github.com/OdujokoD/ALC/blob/master/mockups/screenshot_1.jpg" width="350"/>
  <img src="https://github.com/OdujokoD/ALC/blob/master/mockups/screenshot_2.jpg" width="350"/>

## How do I set up?

* Clone repository
* Import to Android studio and wait for gradle build
* Explore folders to understand workflow


## Bugs and Feedback
For bugs, questions and discussion, please use [Issues](https://github.com/OdujokoD/ALC/issues)

## Who do I talk to?

* Repo owner

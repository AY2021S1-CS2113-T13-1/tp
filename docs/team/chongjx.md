---
layout : page
title : Jun Xiang - Project Portfolio Page
---

## Overview
NotUS is a quick and simple, Command Line Interface (CLI) based, note-taking application for keyboard-inclined users. NotUS allows for users to categorize notes by tagging as well as pinning the more important notes. NotUS is also designed to assist in planning timetables to highlight possible clashes.

*Roles (short for ‘in charge of role’): Description*

- Co-team lead: Responsible for overall project coordination alongside Ramana.
- Software Architect: Designed the software  architecture of the programme with Nazryl. Ensures the logic of the code structure. 
- Integration: Worked with Ramana for the versioning of the code, maintaining the code repository, integrating various parts of the software to create a whole.

## Summary of Contributions

### Features implemented
1\. Implemented `TaggableObject` class which is inherited by `Note` and `Event`. 
- Taggable objects can have multiple tags and different Taggable objects can share same tag(s). They can also be filtered by their tags.

2\. Implemented `Tag` class which contains the name and of the tag and its color.
- Added color support for user to better differentiate the tags.

3\. Implemented `TagManager` class which manages all the tags in application. 
- A hashmap is used where each unique tag are the keys and the arraylist of taggable objects that share the same tag are the mapped values.

4\. Implemented the functionality to create tag, delete tag, as well as tag or untag taggable objects.

5\. Implemented `ParserManager` class which manages the creation of different parser objects to parse the user input to the required parameters.

<div style="page-break-after: always;"></div>

6\. Implemented `SystemException` class which extends from `Exception` class.
- Within it, there is an enumeration for all possible types of exception that may occur and each enum value contains a unique string as its message.

7\. Implemented `Formatter` class which formats the different objects, such as Note, Event and String with a specified layout into a String to be printed.
    
### Code contributed
[RepoSense link](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=chongjx&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Project management
- Set up the framework of the programme for team members to work on.
- Managed code cleanup before every release.
- Managed releases `v1.0`, `v2.0` and `v2.1` on GitHub

### Contributions to User Guide
Added documentation for following features:

1\. [Section 3.11 Create Tags](https://ay2021s1-cs2113-t13-1.github.io/tp/UserGuide.html#create-t)

2\. [Section 3.12 List Tags](https://ay2021s1-cs2113-t13-1.github.io/tp/UserGuide.html#list-t)

3\. [Section 3.13 Tag/Untag Notes](https://ay2021s1-cs2113-t13-1.github.io/tp/UserGuide.html#tag-n)

4\. [Section 3.14 Tag/Untag Events](https://ay2021s1-cs2113-t13-1.github.io/tp/UserGuide.html#tag-e)

5\. [Section 3.15 Delete Tags](https://ay2021s1-cs2113-t13-1.github.io/tp/UserGuide.html#delete-t)

### Contributions to Developer Guide
Added implementation details for the following:

1\. [Section 2.1 Architecture Overview](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#overview)

2\. [Section 2.3 Parser & ParserManager](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#parserManager)

<div style="page-break-after: always;"></div>

3\. [Section 2.4 Commands](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#commands)
- Class diagram of Command Class, Figure 6

4\. [Section 2.7 Tags](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#tag)

5\. [Section 2.9 User Interface](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#ui)

6\. [Section 2.10 SystemException](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#exception)

7\. [Section 2.11 Usage of External Libraries](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#color)

8\. [Section 8.1 List of ParseCommand Classes](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#parseXYZCommands)

9\. [Section 8.2 List of Command Classes](https://ay2021s1-cs2113-t13-1.github.io/tp/DeveloperGuide.html#XYZCommands)

### Community
1\. Reviewed most of the PRs to ensure the Classes and functions follow the project architecture as well code logic of the programme.
- Reviewed a total of 66 PRs out of 114 PRs, with [167 comments](https://nus-cs2113-ay2021s1.github.io/dashboards/contents/tp-comments.html), dated 7/11/2020.

2\. Reported bugs and suggested fixes for team members. ([#115](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/115), [#135](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/135), [#148](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/148), [#159](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/159), [#168](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/168), [#175](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/175) and [#199](https://github.com/AY2021S1-CS2113-T13-1/tp/issues/199))

3\. Contributed to forum discussions on usage of Jcolor and jansi libraries. ([#86](https://github.com/nus-cs2113-AY2021S1/forum/issues/86) and [#93](https://github.com/nus-cs2113-AY2021S1/forum/issues/93))

### Tools:
1\. Integrated a third party library [(JColor)](https://github.com/dialex/JColor) to the project. [(#37)](https://github.com/AY2021S1-CS2113-T13-1/tp/pull/37)

2\. Integrated a third party libaray [(jansi)](https://fusesource.github.io/jansi) to the project. [(#87)](https://github.com/AY2021S1-CS2113-T13-1/tp/pull/87)


<div style="page-break-after: always;"></div>

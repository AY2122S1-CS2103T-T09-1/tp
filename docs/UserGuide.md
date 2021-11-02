---
layout: page
title: User Guide
---

<img src="images/study_tracker_logo.png" alt="logo"/>

StudyTracker is a **desktop app** that **tracks your most productive study spots**, optimized for students who are familiar with **Command Line Interfaces (CLI)**.

**StudyTracker was built to solve the problem of not finding productive study spots**.
We aim to **maximise students' productivity** by **making it easy to find the best place to study.**

Overview of main features:
- **Make informed decisions** of where to study —  every study spot includes details about amenities like sockets, aircon, and crowd level, and more!
- **Data-driven statistics** to **track time spent studying** ensures you know where to go to be productive
- Made a mistake? Found out something new? **Editing details is quick and simple!**
- **Powerful customization** with user-defined aliases and custom themes!
- **Built for cross-platform use** with JavaFX. Bring your StudyTracker data with you to any Windows, Mac, or Linux device!

StudyTracker is full of features, but don't worry!
This **User Guide** provides clear, step-by-step information to use StudyTracker. If this is your first time using StudyTracker, [**How to use this guide**](#how-to-use-this-user-guide) is the perfect place to start.


**Open up StudyTracker, and let's get on the right track to productivity!**

Want to contribute to development? Check out the [**Developer Guide**](DeveloperGuide.html) instead.

<div style="page-break-after: always;"></div>

---

## Table of Contents

* Table of Contents
{:toc}

---

<div style="page-break-after: always;"></div>

## Quick Start

StudyTracker comes with sample data.
In this **Quick Start** section, we'll go through **a tutorial to try the essential features of StudyTracker.**

Let's explore how we **add a new study spot** and **track our study time** with it:

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `StudyTracker.jar` from [here](https://github.com/AY2122S1-CS2103T-T09-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your StudyTracker.

1. Double-click the file to start the app. The GUI similar to the one below should appear in a few seconds. Note how the app contains some sample data.<br>

    <img src="images/Ui.png" alt="Default Ui" width="550"/>

1. Type the command in the [command box](#study-spot-list) and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>

    Do the following commands in sequence:

   1. **`list`** : Lists all study spots.
    Study spots are shown in cards on the right panel of the program.

   1. **`add`** `n/FASS Benches r/5 m/wifi` : **Adds a study location** named `FASS Benches`, with a rating of 5 and 'wifi' amenity to the StudyTracker.
   You'll see it if you scroll down the list of study locations!

   1. **`log`** `n/FASS Benches hr/3` : **Logs 3 hours of study time** at `FASS Benches`.
    The card will update with the new study hours. Notice how the pie chart on the left of the GUI updates with the hours spent!
    Try hovering over the pie chart to find your newly-added study spot!

   1. **`exit`** : Exits the app.

1. Congratulations! You've just added a new study spot, and logged your study time!
You're on the right track to productivity!

1. Refer to the [Features](#features) section for more commands and features in StudyTracker.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Check out **<a href="#command-structure">How to read Commands in StudyTracker</a>** section if you are unfamiliar with CLI syntax!
</div>    

<div style="page-break-after: always;"></div>

---
## How to use this User Guide

This section provides tips on reading this document, as well as how to navigate it.

This User Guide is structured so that it is easy for you to find what you need.
If this is your first time using StudyTracker, we recommend reading the User Guide in order, starting from this section.

It is recommended that you have the StudyTracker application open, so you can try out the commands and features!

The [**Table of Contents**](#table-of-contents) contains links to all the sections of the guide.

[**Common Symbols found in this guide**](#common-symbols-found-in-this-guide) and [**How to read Commands in StudyTracker**](#how-to-read-commands-in-studytracker) section will help you understand this document better.
You can then look at the [**GUI Layout**](#gui-layout) and [**Features**](#features) sections for clear instructions for using StudyTracker.

### Common Symbols found in this guide

| Symbol | Description |
| --- | ----------- |
| :information_source: | This symbol indicates that something important to take note of. |
| :bulb: | This symbol indicates that we are mentioning a tip. |
| :warning: | This symbol indicates something to be careful of. |

### How to read Commands in StudyTracker

Throughout the User Guide, you'll see commands to enter into StudyTracker.
Here is how to read the command format:

#### Command Structure
Commands use a multipart structure that must be specified in this order:
1. **Command word** which may be user-created aliases (detailed further in [**Aliases**](#setting-command-aliases--alias-unalias)). <br>
2. **Parameters** and **Flags**. A command may have more than one flag and/or parameters.

<img src="images/commandStructure.png" alt="commandStructure" height="300"/>

#### Flags

Commands may require **flags**.
  Flags are represented by a dash, and a sequence of characters. <br>
  e.g. the `list` command has a `-f` flag to list only favourites.

#### Parameters

* Each parameter may have a delimiter. <br>
e.g. the `NAME` parameter has a delimiter `n/` and the `AMENITY` parameter has a delimiter `m/`.

* You will supply words in `UPPER_CASE` as the parameters.<br>
  e.g. in `add n/NAME*`, `NAME` is a parameter which can be used as `add n/COM1 Basement`.

* You are **required** to enter parameters with an asterisk `*`, while those without an asterisk are 
  optional.<br>
  e.g You can use `n/NAME* m/AMENITY...` as `n/COM1 Basement m/wifi` or as `n/COM1 Basement`.

* Parameters with `…`​ after them can be used multiple times including zero times.<br>
  e.g. You can use `t/TAG...​` as ` ` (i.e. 0 times), `t/noisy`, `t/mosquitos t/sunny` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME* a/ADDRESS`, `a/ADDRESS n/NAME*` is also acceptable.

<div markdown="block" class="alert alert-warning">:warning: **Caution:**

* If a parameter is expected only once in the command, but you specified it multiple times, only the **last occurrence** of the parameter will be taken.<br>
  e.g. if you specify `n/COM1 n/CLB`, StudyTracker will only take `n/CLB`.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.
</div>


### How to use these Commands in Command Line Interface
If this is your first time using *Command Line Interface (CLI)*, fret not and we will guide you step-by-step on how to use CLI!

You tell the *Command Line Interface* exactly what you want it to do! However, if you input something that the CLI does not understand, 
then the program will not be able to help you. Inputs that the CLI understand are called **valid**, while those that are not understood are
called **invalid**.

Some **valid** user inputs for the [*add command*](#adding-a-study-spot-add) are provided below:
* `add n/PC Commons a/UTown t/veryCrowded m/toilet r/4`
* `add n/COM2 Basement r/3` (optional arguments are not required)
* `add n/TR3 a/Yusof Ishak House m/wifi m/aircon` (multiple amenities are acceptable)

Some **invalid** user inputs for the *add command* are provided below:
* `add n/PC Commons` (missing `RATING` parameter)
* `add PC Commons /UTown /very crowded /toilet /4*` (delimiters and slashes missing from parameters, unnecessary asterisk added outside of parameters)
* `n/PC Commons a/UTown r/4` (missing command word `add`)

If you accidentally entered a wrong command, don't worry! A comprehensive error message will show up 
in the display immediately to guide you to entering the correct command.

1. In the [Graphical User Interface Layout](#gui-layout), the **Command Box** can be found at the bottom. This is where you will
tell the program what to do.
   
1. Click on the box that says "Enter command here...", and simply type in whatever input you want.

1. Press enter (or click the send button) to submit the command to the program. Remember that the input should be valid! Or else
the program will not know what to do 😢.
   
1. After pressing enter, your command has successfully been given to StudyTracker to be processed! You have just successfully **executed** a command.

Congratulations! 🎉 You should now know how to use CLI. Now all you need to know are the **commands** you can give to the CLI to play around with it.

<div style="page-break-after: always;"></div>

## GUI Layout

This section introduces the Graphical User Interface (GUI) of StudyTracker.

![Gui annotated](images/GuiAnnotated.png)

The top of the interface contains the **Menu Bar**. Clicking on `File` or `Help` will open up the [Settings menu](#managing-themes) and the [Help window](#viewing-help--help).

On the left side of the interface, you can find the [**Info Display**](#info-display).

On the right side of the interface, you can find the [**Study Spot List**](#study-spot-list) and [**Command Box**](#study-spot-list).

### Info Display

The **Info Display** contains the **Pie Chart** and **Favourites List**.

![Gui annotated](images/GuiInfoDisplayAnnotated.png)

The **Hours Studied Pie Chart** displays statistics of time spent studying at the *top five most frequented* study spots.

* Moving your cursor over any segment of the pie chart will show a `Study Spot Caption` with details of the corresponding study spot
* `Total hours studied` will show the total number of hours studied over all study spots

The **Favourites List** contains **Cards** representing all [**favourited**](#adding-a-study-spot-to-favourites-fav) study spots in StudyTracker.
The `Total` tag at the top shows total number of favourited study spots in StudyTracker.

* `Name` — name of study spot
* `Tags` — user-defined tags for the study spot
* `Amenities` — the icons represent the amenities present in study spot.
From left to right, the amenities are **aircon, charger, food, wifi**.
* `Hours studied` — total number of hours studied at study spot


### Study Spot List


![Gui annotated](images/GuiStudySpotListAnnotated.png)

The **Study Spot List** contains **Cards** representing every study spot in StudyTracker.
The `Total` tag at the top shows current visible study spots/total number of study spots in StudyTracker.
Scroll down the list to view all the study spots!
* `Name` — name of study spot
* `Tags` — user-defined tags for the study spot
* `Address` — address of study spot
* `Operating Hours` — operating hours of study spot, weekdays and weekends
* `Favourite` — this icon shows if the study spot is added to favourites
* `Amenities` — the icons represent the amenities present in study spot.
From left to right, the amenities are **aircon, charger, food, wifi**.
* `Hours` — total number of hours studied at study spot
* `Rating` — user-defined rating for the study spot

The **Command Box** is where to enter [**commands**](#how-to-read-commands-in-studytracker) in StudyTracker.

* `Command Box` — type in your commands here
* `Display` — results of commands and error messages are shown here.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Check out <a href="#managing-themes">Managing Themes</a> section to change the theme of the GUI!
</div>

## Features

This section introduces all the features in StudyTracker.

Features are grouped according to usage.
Click on the groups to view clear, step-by-step usage instructions!


| Features | Usage and commands|
|----------|------------------ |
| **[Managing study spots](#managing-study-spots)** | Commands that manage the study spots in this app <br> **Commands**: add, edit, fav, unfav, delete, clear |
| **[Managing StudyTracker list](#managing-studytracker-list)** | Commands to filter and view specific study spots <br> **Commands**: list, find |
| **[Logging study hours](#logging-study-hours-log)**| Commands to log study hours <br> **Commands**: log |
| **[Setting aliases](#setting-command-aliases)**| Commands to create and remove aliases <br> **Commands**: alias, unalias |
| **[Viewing help](#viewing-help--help)** | View the built-in help manual <br> **Commands**: help |
| **[Exiting the program](#exiting-the-program--exit)**| Exit StudyTracker <br> **Commands**: exit |
| **[Managing themes](#managing-themes)**| Customize the look of StudyTracker |
| **[Data](#data)** | Manage and save user data and user preferences |

### Managing study spots 

#### Adding a study spot: `add`

You can add a study spot to StudyTracker by making use of the `add` command.

**Format:** `add n/NAME* r/RATING* a/ADDRESS t/TAG... m/AMENITY... o/OPERATING_HOURS`

* Adds a study spot with `NAME`.
* You can only add amenities from this list of 4 amenities: `wifi`, `food`, `charger`, `aircon`. Any other amenities 
  entered will give you an error message. 
* You can only enter tags that are one-word long. If you wish to use more than one word, you can use Camel Case 
  (e.g. `t/veryCrowded`) 
* You can only enter ratings that are integers from 0 to 5, inclusive.  

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
Tags, amenities, address and operating hours are all optional.
</div>
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Not sure how to use the Command Line Interface? Check <a href="#how-to-use-these-commands-in-command-line-interface">this</a> guide out!
</div>

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

add n/COM1 Basement r/5

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

New study spot added: COM1 Basement; Rating: 5; Favourite: false; Studied Hours: 0

</td>
  </tr>
  <tr align="left">
    <th>Input 2</th>
    <td>

add n/Starbucks at UTown r/4 t/noisy m/wifi o/0800-2000,0900-2200

</td>
  </tr>
  <tr align="left">
    <th>Output 2</th>
    <td>
New study spot added: Starbucks at UTown; Rating: 4; Operating Hours: Weekdays: 0800-2000, Weekends: 0900-2200; Tags: [noisy]; Amenities: [wifi]

</td>
  </tr>
</table>


<div style="page-break-after: always;"></div>

#### Editing a study spot : `edit`

If you made a mistake in your `add` command, or wish to change the details of a study spot, 
you can easily do so by making use of the `edit` command!

**Format:** `edit spot/NAME* n/NEW_NAME a/NEW_ADDRESS t/NEW_TAG m/NEW_AMENITY r/NEW_RATING o/NEW_OPERATING_HOURS`

* Edits the study spot matching `NAME`.
  The provided `NAME` is not case-sensitive and **must fully match the study spot name**.
* You must provide **at least one** of the optional fields.
* StudyTracker will update the details of the given study spot with the provided `NEW_NAME`, `NEW_ADDRESS`, `NEW_RATING` or `NEW_OPERATING HOURS`.
* When editing tags and amenities, `t/` or `m/` will be adding on top of existing tags and amenities.
* You can remove a specific tag or amenity with the `rt/` or `rm/` parameter.
* You can remove all the study spot’s tags by typing `t/` or `m/` without
  specifying any tags after it.

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

edit spot/COM1 Basement n/Basement

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Edited study spot: Basement; Rating: 5; Favourite: false; Studied Hours: 0

</td>
</tr>
</table>

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
The above input assumes that there is already a study spot named "COM1 Basement" in the Study Tracker!
This input only changes the name from "COM1 Basement" to "Basement".
</div>

<div style="page-break-after: always;"></div>

#### Adding a study spot to Favourites: `fav`

Really enjoyed studying somewhere? You can add this study spot to your favourites by using the `fav` command! This will 
make the Study Spot appear in the [Favourites List](#info-display), reminding you of the place every time you open StudyTracker.

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
Don't forget to add the spot to your StudyTracker before using the fav command! Alternatively, you could use the 
add command and directly mark it as a favourite using that command!
</div>

**Format:** `fav n/NAME*`

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

fav n/COM1 Basement

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Added study spot to favourites: COM1 Basement

</td>
</tr>
</table>

<img src="images/add_favourites.png" alt="favourites" height="700"/>

<div style="page-break-after: always;"></div>

#### Removing a study spot from Favourites: `unfav`

Did one of your favourite study spots suddenly decide to ban students from studying there, and you decide it is time to unfavourite a spot?
You can make use of the `unfav` command to do so.

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
The study spot you are trying to unfavourite should originally be a favourite!
</div>

**Format:** `unfav n/NAME*`

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td>

unfav n/COM1 Basement

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Removed study spot from favourites: COM1 Basement

</td>
</tr>
</table>

#### Deleting a study spot : `delete`

Want to get rid of study spots that you don't wish to remember? You can use the `delete` command to do so.

**Format:** `delete n/NAME*`

* Deletes the study spot matching `NAME`.
  The provided `NAME` is not case-sensitive and **must fully match the study spot name**.

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

delete n/Basement

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Deleted study spot: Basement 

</td>
</tr>
</table>

### Clearing all entries : `clear`

Moving to a new location and decide to start your list afresh? You can make use of the `clear` command to clear the entire list of
study spots.

<div markdown="span" class="alert alert-warning">:warning: **Caution:**
This command is irreversible!
</div>

**Format:** `clear`

**Example:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td>

clear

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

StudyTracker has been cleared!

</td>
</tr>
</table>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
If you wish to clear all your study spots while keeping the data you originally stored, you can make a copy of the 
studytracker.json file which should be found within the data folder of the file with StudyTracker!
</div>


<div style="page-break-after: always;"></div>

### Managing StudyTracker list

#### Listing study spots : `list`

Want to find all the study spots that have the amenity "aircon"? Or perhaps list all the study spots you tagged with 
"freewater"? You can make use of the `list` command and its various different [flags](#flags) to get what you want. 
<br> Note that the results of the `list` command will only contain StudySpots that matches **ALL** the 
specifications provided by the user. 

Below shows the corresponding [flag](#flags) to its function.

| Flag     | Function |
| ----------- | ----------- |
| No flag (i.e. `list`)      | Lists out all study spots (clears any filters previously applied)       |
| `-f`   | Shows all favourited study spots        |
| `-t t/TAG` | Shows all study spots with the specified tags |
| `-m m/AMENITY` | Shows all study spots with the specified amenities |
| `-r r/RATING` | Shows all study spots with the given rating |

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
You can use multiple flags at once.
</div>

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

list 

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Listed all study spots

</td>
  </tr>
  <tr align="left">
    <th>Input 2</th>
    <td>

list -f -t t/cold -m m/wifi -r r/5

</td>
  </tr>
  <tr align="left">
    <th>Output 2</th>
    <td>

Listed all study spots in Favourites with Tags: [cold] with Amenities: [wifi] with Rating: 5
</td>
  </tr>
</table>

<img src="images/list_tags_cold.png" alt="cold tags" height="700"/>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Make use of command aliases to speed up typing your inputs!
</div>

[**Default Command alias:**](#setting-command-aliases) `ls`

#### Locating a study spot by name: `find`

Trying to find a study spot by it's name? You can use the `find` command to easily do so!

**Format:** `find KEYWORD* [MORE KEYWORDS]`

* The search is case-insensitive. e.g `library` will match `Library`
* StudyTracker will only match full words. e.g. `Lib` will not match `Library`
* StudyTracker will return study spots matching at least one keyword.
* For example, `find library spot` will match `Central Library` and `Cool Spot` as both the search results for `library` and `spot` are shown.

**Examples:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

find library

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

3 study spot(s) listed!

</td>
</tr>
</table>

### Logging study hours: `log`

After studying at a certain study spot, you can `log` how many hours you have studied at this location.
There are also various flags you can use to reset or override hours to the value of your choice.
Use the `-r` and `-o` flags respectively, as shown
below:

| Format     | Function |
| ----------- | ----------- |
| `log n/NAME* hr/NUM_OF_HOURS*` | Adds the given `NUM_OF_HOURS` to the original studied hours at a study spot |
| `log -o n/NAME* hr/NUM_OF_HOURS*` | Overrides the current studied hours with the given `NUM_OF_HOURS`  |
| `log -r n/NAME*` | Resets the number of studied hours at a study spot to 0 |
| `log -r` | Resets studied hours of **ALL** study spots to 0 |

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
The flag `-o` stands for override, which overrides the studied hours with the provided value <br>
The flag `-r` stands for reset, which resets the hours to 0
</div>


**Example:** You can try executing the commands in the **input** rows and check if you get the corresponding **output**!

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

log n/Starbucks UTown hr/2

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Logged 2 hours at Starbucks UTown!

</td>
  </tr>
  <tr align="left">
    <th>Input 2</th>
    <td>

log -o n/Starbucks UTown hr/5

</td>
  </tr>
  <tr align="left">
    <th>Output 2</th>
    <td>

Changed hours to 5 at Starbucks UTown!
</td>
  </tr>
  <tr align="left">
    <th>Input 3</th>
    <td>

log -r n/Starbucks UTown

</td>
  </tr>
  <tr align="left">
    <th>Output 3</th>
    <td>

Reset hours at Starbucks UTown!
</td>
  </tr>
  <tr align="left">
    <th>Input 4</th>
    <td>

log -r

</td>
  </tr>
  <tr align="left">
    <th>Output 4</th>
    <td>

Reset hours for all study spots!
</td>
  </tr>
</table>

<img src="images/log_hours.png" alt="log hours" />

Logging 2 hours to 'Starbucks UTown' with the command `log n/starbucks utown hr/2` (as seen in Input 1) would update the **study spot card**, as well as statistics on the **pie chart**.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Use the log command at the end of a study session to keep track of how long you studied somewhere!
</div>

### Setting Command Aliases

#### Adding command aliases : `alias`, `unalias`

Do you find yourself using certain commands so often that you wish you could "code-name" it so you don't need to type so much? 
Alias is the command for you. The `alias` command can help you to shorten input commands to whatever you want it to be. 

| Format     | Function |
| ----------- | ----------- |
| `alias -s` | Shows all aliases that you have set |
| `alias al/ALIAS* cmd/COMMAND*` | Sets and alias, where `ALIAS` is the shortcut and `COMMAND` is the given input you wish to alias  |

**Example:** 

| Input     | Output | Usage of Alias | Output |
| ----------- | ----------- | ---------- | ------------- |
| `alias al/MyList cmd/list` | `Added alias myList: [list]` | `myList` | `Listed all study spots` |

* running `myList` will run the `list` command.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can chain aliases to make more powerful commands! See the below example.<br> <br>
</div>

**Example:** <br>

| Input     | Output | Usage of Alias | Output |
| ----------- | ----------- | ---------- | ------------- |
| `alias al/LogCLB cmd/log n/Central Library hr/` | `Added alias LogCLB: [log n/Central Library hr/]` | `LogCLB 3` | `Logged 3 hours at Central Library!`|



Running `LogCLB 3` would then result in `log n/Central Library hr/3`, allowing you to log a variable number of study hours to 'Central Library'!


#### Removing command aliases: `unalias`

If you do not like an alias you originally set, you can use `unalias` to remove that alias.

**Format:** `unalias al/ALIAS*` to remove alias

**Example:**

<table>
  <tr>
    <th width="90" align="left">Input 1</th>
    <td >

unalias al/MyList

</td>
  </tr>
  <tr align="left">
    <th>Output 1</th>
    <td>

Removed alias 'myList'

</td>
</tr>
</table>

<div style="page-break-after: always;"></div>

### Viewing help : `help`

Forgot a command? You can make use of the `help` command to get a quick overview of all commands available in StudyTracker!

Click on each command on the left panel to view usage instructions of each command.

You can also visit the User Guide and Developer Guide by clicking on the buttons in the window.
![Help window](images/helpMessage.png)

Format: `help`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
View the help window anytime by using the F1 shortcut!
Alternatively, click on 'Help' in the menu bar!
</div>

<div style="page-break-after: always;"></div>

### Exiting the program : `exit`

Hands off the mouse and want to quickly close the app without getting your hands off the keyboard? Simply execute the `exit` command!

**Format:** `exit`

[**Default Command alias:**](#setting-command-aliases) `bye`, `quit`

<div style="page-break-after: always;"></div>

### Managing Themes
Personality matters, and you should be given a way to select a theme that speaks to you!

From `File > Settings`, select the colour theme you wish to use. Themes are saved in your user preferences, so the next time you 
launch the application, rest assured that your colour theme will be set and ready to go!

![Gui Themes](images/UiThemes.png)

<div style="page-break-after: always;"></div>

### Data

#### Saving data

StudyTracker's data is saved in the hard disk automatically after any command that changes the data. You can rest assured that you do
not need to save your data manually.

#### Editing the data file

StudyTracker data are saved as a JSON file `[home folder]/data/studytracker.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:warning: **Caution:**
If your changes to the data file makes its format invalid, StudyTracker will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

This section contains frequently asked questions (FAQs) about StudyTracker.

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty **data** file it creates with the file that contains the data of your previous StudyTracker home folder.
You may also copy the **preferences.json** file to keep your user preferences.

**Q**: How should tags be used? <br>
**A**: Tags are short bites of information about study spots. It is up to you to define how you use them. One way is to use `list` to filter for study spots with a specified tag. You can refer to [List](#listing-study-spots--list) for more details.

**Q**: How do I receive updates for this app? <br>
**A**: Currently, the app does not automatically update. You can check out the latest version [here](https://github.com/AY2122S1-CS2103T-T09-1/tp/releases). Simply replace your current JAR file with the latest version.

**Q**: Can I contribute to the code as well? <br>
**A**: Yes, of course! We're open-source and are open to new ideas. You can contact anyone in the team on [Github](https://github.com/AY2122S1-CS2103T-T09-1/tp) and create a pull request [here](https://github.com/AY2122S1-CS2103T-T09-1/tp/pulls).

**Q**: What do I do when I encounter bugs?<br>
**A**: As much as possible, we rigorously test our application before it is released. However, should you encounter bugs, you can raise issues to our team [here](https://github.com/AY2122S1-CS2103T-T09-1/tp/issues) and we would look to fix them in upcoming patches.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME* r/RATING* a/ADDRESS t/TAG... m/AMENITY... o/OPERATING_HOURS` <br> e.g. `add n/COM1 r/5`
**Edit** | `edit spot/NAME* n/NEW_NAME a/NEW_ADDRESS t/NEW_TAG m/NEW_AMENITY r/NEW_RATING o/NEW_OPERATING_HOURS`<br> e.g.,`edit n/tr3 n/Training Room 3`
**Favourite**  |  `fav n/NAME*` <br> e.g. `fav n/COM1`
**Unfavourite** | `unfav n/NAME*`
**Delete** | `delete n/NAME*` <br> e.g. `delete n/COM1`
**List** | `list -f -t t/TAG...`
**Find** | `find KEYWORD* [MORE KEYWORDS]*`<br> e.g. `find library`
**Log** | `log -o n/NAME* hr/NUM_OF_HOURS*` <br> e.g. `log -o n/Starbucks hr/5`
**Alias** | `alias al/ALIAS* cmd/COMMAND*`<br> e.g. `alias al/home cmd/find home`
**Unalias** | `unalias al/ALIAS*`
**Clear** | `clear`
**Help** | `help`
**Exit** | `exit`

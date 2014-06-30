<h1 style="font-size:4em">Technical Report</h1>
<h2 style="font-size:2.5em;margin:-50px 0 500px">Baltic Sea Weather Data</h2>

> __Assignment:__ Technical Report, Learning Task 5, Group 1, Theme 2.1-I
>
> __Authors:__ <span style="display:inline-block;vertical-align:top">Tom Broenink, Ward Holthof, Yuri Hoogeweg,<br/>André Nanninga, and Maurits van Mastrigt</span>
>
> __Date:__ June 30th 2014

<!-- header: Technical Report, Learning Task 5, Group 1, Theme 2.1-I -->

# Table of Contents
- __1 &nbsp;Introduction									<span style="float:right">3</span>__
- __2 &nbsp;Application Specification						<span style="float:right">4</span>__
	- 2.1 &nbsp;Requirements								<span style="float:right;font-weight:normal">4</span>
	- 2.2 &nbsp;Goals										<span style="float:right;font-weight:normal">5</span>
- __3 &nbsp;Application Design								<span style="float:right">6</span>__
	- 3.1 &nbsp;UNWDMIDP									<span style="float:right;font-weight:normal">6</span>
	- 3.2 &nbsp;Ant											<span style="float:right;font-weight:normal">7</span>
	- 3.3 &nbsp;Vagrant										<span style="float:right;font-weight:normal">7</span>
	- 3.4 &nbsp;Meteor										<span style="float:right;font-weight:normal">7</span>
	- 3.5 &nbsp;Map Reduce									<span style="float:right;font-weight:normal">8</span>
	- 3.6 &nbsp;D3											<span style="float:right;font-weight:normal">8</span>
	- 3.7 &nbsp;Backups										<span style="float:right;font-weight:normal">11</span>
- __4 &nbsp;Test Results										<span style="float:right">12</span>__
	- 4.1 &nbsp;Weather Data								<span style="float:right;font-weight:normal">12</span>
	- 4.2 &nbsp;First Query									<span style="float:right;font-weight:normal">13</span>
	- 4.3 &nbsp;Second Query								<span style="float:right;font-weight:normal">14</span>
	- 4.4 &nbsp;Conclusion									<span style="float:right;font-weight:normal">15</span>
- __5 &nbsp;Glossary											<span style="float:right">16</span>__

# 1 Introduction

<!-- @include General/Introduction.md -->

# 2 Application Specification

<!-- @include Specification/Intro.md -->
<!-- @include Specification/Requirements.md -->
<!-- @include Specification/Goals.md -->

# 3 Applicaton Design

<!-- @include Design/Intro.md -->
<!-- @include Design/UNWDMIDP.md -->
<!-- @include Design/Ant.md -->
<!-- @include Design/Vagrant.md -->
<!-- @include Design/Meteor.md -->

---

<!-- @include Design/MapReduce.md -->
<!-- @include Design/D3.md -->
<!-- @include Design/D3/Line Graphs.md -->

---

<!-- @include Design/D3/Geodata.md -->
<!-- @include Design/D3/Hexbin.md -->

---

<!-- @include Design/Backups.md -->

# 4 Test Results

<!-- @include Tests/Intro.md -->
<!-- @include Tests/WeatherData.md -->

---

<!-- @include Tests/FirstQuery.md -->

---

<!-- @include Tests/SecondQuery.md -->

---

<!-- @include Tests/Conclusion.md -->

# 5 Glossary

<!-- @include Glossary/Glossary.md -->

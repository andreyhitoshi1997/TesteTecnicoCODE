# Amazon Automation Testing Project

This repository contains an automated testing suite for the Amazon Brazil (amazon.com.br) homepage, developed as part of a technical challenge for a Quality Analyst position. The project focuses on testing autocomplete suggestions, navigation menu functionality, and page load performance using Java, Selenium, and Cucumber. The challenge specification is based on the provided [ODS spreadsheet](https://github.com/your-username/amazon-automation/blob/main/Desafio_Tecnico.ods), which outlines the requirements and evaluation criteria.

## Overview

- **Purpose**: Validate key functionalities of the Amazon homepage in mobile mode (375x812 resolution) as per the technical challenge.
- **Features Tested**:
  - Autocomplete suggestions when typing in the search bar.
  - Responsive navigation menu (open and navigable).
  - Page load performance (< 3 seconds).
- **Tools**:
  - Language: Java
  - Frameworks: Selenium WebDriver, Cucumber (BDD)
  - Build: Maven
  - Reporting: Cucumber HTML Reports

## Challenge Specification (from ODS)

- **Deadline**: 2 days from document receipt (completed within timeframe).
- **Scope**: Focused on autocomplete, navigation menu, and performance; optional depth based on priority.
- **Requirements**:
  - **Autocomplete**: Suggest related results as user types.
  - **Navigation Menu**: Responsive across desktop, tablet, and mobile.
  - **Performance**: Fast page load on various devices and browsers.
- **Tasks**:
  - Create test cases covering positive, negative, functional, usability, and performance scenarios.
  - Automate tests with Java and a chosen framework (Selenium/Cucumber).
  - Prepare a presentation with test strategy, results, and recommendations.
- **Evaluation Criteria**:
  - Coverage and depth of critical functionalities.
  - Quality of automation (clean, efficient, documented code).
  - Analysis and reporting of defects.
  - Identification of performance/usability issues with solutions.

## Prerequisites

- **Java**: JDK 21 or later
- **Maven**: For dependency management
- **ChromeDriver**: Version 134.0.6998.88 (compatible with Chrome 134.0.6998.35)
  - Download and add to your PATH or specify in `SearchSteps.java`
- **IDE**: IntelliJ IDEA or similar (recommended)

## Setup

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/your-username/amazon-automation.git
   cd amazon-automation

# DiskPlay: Disk Scheduling Simulator

## Table of Contents
- [Overview](#overview)
- [Algorithms](#algorithms)
- [Features](#features)
- [Files and Directories](#files-and-directories)
- [Getting Started](#getting-started)
  - [Prerequites](#prerequisites)
  - [User System Flow](#user-system-flow)
  - [Preview](#preview)
- [Contribution](#contribution)
  - [License](#license)

## Overview
**DiskPlay** is a desktop application for simulating various disk scheduling algorithms. It offers interactive input methods, animated visualizations, and exportable outputs for educational and analytical use.

## Algorithms
- FCFS (First-Come, First-Served)
- SSTF (Shortest Seek Time First)
- SCAN
- C-SCAN
- LOOK
- C-LOOK

## Features
- **Three Input Options**:
  - **Random Generation** – auto-generates queue length, cylinder positions, and head start.
  - **Manual Input** – enter request queue, head position, and direction via GUI.
  - **Text File Input** – load input from a structured `.txt` file.

- **Simulation Visualization**:
  - Cylinders displayed as labeled dots (0–199)
  - Dynamic connection between head movements
  - Adjustable animation speed using a timer

- **Export Options**:
  - Save simulation result as image or PDF
  - File name format: `mmddyy_hhmmss_DS`

## Input Modes

### 1. Random Input

When selected:
- Queue length is randomly chosen (max 40)
- Cylinders selected within range 0–199
- Head position randomly generated

### 2. Manual Input (via GUI)

Users can input:
- Number of requests (≤ 40)
- Request queue (e.g., `82,170,43,140,24,16,190`)
- Initial head position (0–199)
- Movement direction (`left` or `right` if needed)

### 3. Input from Text File

You can provide the input through a `.txt` file with the following format:

<number_of_requests> <comma_separated_requests> <initial_head_position> <direction> 

**Example File Content**:
7 82,170,43,140,24,16,190 50 right

**Explanation**:
- `7` – number of requests
- `82,170,43,140,24,16,190` – list of cylinder positions in the queue
- `50` – initial R/W head position
- `right` – direction of head movement (`left` or `right`) for applicable algorithms

## Output

Each simulation displays:
- A graphical path showing R/W head movement
- Dots labeled with cylinder values
- **Total Seek Time** calculated and shown at the end

## Exporting Results

After simulation:
- You can save results as:
  - `.pdf`
  - `.png`
  - `.jpg`
- Exported file uses the format: `mmddyy_hhmmss_DS`

## Adjustable Simulation Timer

Use the timer control to:
- Slow down or speed up simulation
- Pause between head movements for better observation

## How to Run in VS Code Terminal

1. Compile:  javac -cp "lib/*" src/*.java 
2. Run: java -cp "src:lib/*" DiskPlay

## Contribution
Developed by **Emiline Acompañado, Andrea Mae Orbase, Richard Biscante**
as partial fulfillment of CMSC 125



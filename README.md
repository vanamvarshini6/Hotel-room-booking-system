# Hotel Room Booking System 

A simple Java Swing-based desktop application for managing hotel room bookings with real-time cost calculation.

## 📋 Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Requirements](#requirements)
- [Installation & Setup](#installation--setup)
- [Implementation Steps](#implementation-steps)
- [Usage Guide](#usage-guide)
- [Code Components](#code-components)
- [Troubleshooting](#troubleshooting)
- [Future Enhancements](#future-enhancements)

---

## ✨ Features

- **User-Friendly GUI** - Clean and intuitive Swing-based interface
- **Multiple Room Types** - Choose from Standard, Deluxe, or Suite rooms
- **Flexible Booking Duration** - Select any number of days for your stay
- **Automatic Cost Calculation** - Real-time total amount calculation based on room type and duration
- **Input Validation** - Error handling for invalid number of days
- **Quick Reset** - Clear button to reset form fields instantly
- **Booking Confirmation** - Detailed confirmation dialog with booking summary

---

## 🏗️ Architecture

### System Architecture Overview

The application follows a **Three-Layer Architecture Model**:

```
┌─────────────────────────────────────────────┐
│      PRESENTATION LAYER (GUI)               │
│  ┌──────────────────────────────────────┐   │
│  │ • JFrame (Main Window)               │   │
│  │ • JLabel (Title, Labels)             │   │
│  │ • JTextField (Input Fields)          │   │
│  │ • JComboBox (Room Selection)         │   │
│  │ • JButton (Book, Clear)              │   │
│  └──────────────────────────────────────┘   │
└─────────────────────────────────────────────┘
                    ↓
┌─────────────────────────────────────────────┐
│     BUSINESS LOGIC LAYER                    │
│  ┌──────────────────────────────────────┐   │
│  │ • Input Validation                   │   │
│  │ • Room Type → Price Mapping          │   │
│  │ • Cost Calculation (Price × Days)    │   │
│  │ • Data Processing                    │   │
│  └──────────────────────────────────────┘   │
└─────────────────────────────────────────────┘
                    ↓
┌─────────────────────────────────────────────┐
│   EVENT HANDLING LAYER                      │
│  ┌──────────────────────────────────────┐   │
│  │ • ActionListener (Button Events)     │   │
│  │ • Book Button Handler                │   │
│  │ • Clear Button Handler               │   │
│  │ • Dialog Management                  │   │
│  └──────────────────────────────────────┘   │
└─────────────────────────────────────────────┘
```

### Component Hierarchy

```
HotelRoomBookingSystem (Main Class extends JFrame)
│
├─ GUI COMPONENTS
│  ├─ titleLabel (JLabel) - "Hotel Room Booking"
│  ├─ nameLabel (JLabel) - "Customer Name:"
│  ├─ nameField (JTextField) - Input field for guest name
│  ├─ roomLabel (JLabel) - "Room Type:"
│  ├─ roomBox (JComboBox) - Room selection dropdown
│  │  ├─ "Standard - ₹1500/day"
│  │  ├─ "Deluxe - ₹2500/day"
│  │  └─ "Suite - ₹4000/day"
│  ├─ daysLabel (JLabel) - "No. of Days:"
│  ├─ daysField (JTextField) - Input field for number of days
│  ├─ bookButton (JButton) - Book Room action
│  └─ clearButton (JButton) - Clear form action
│
├─ EVENT HANDLERS
│  ├─ BookButton.actionPerformed()
│  │  ├─ Get customer name
│  │  ├─ Get selected room type
│  │  ├─ Get number of days
│  │  ├─ Validate days (Integer.parseInt)
│  │  ├─ Extract price from room string
│  │  ├─ Calculate total (price × days)
│  │  └─ Show confirmation dialog
│  │
│  └─ ClearButton.actionPerformed()
│     ├─ Clear nameField
│     ├─ Clear daysField
│     └─ Reset roomBox to index 0
│
└─ CONFIGURATION
   ├─ Layout: GridLayout (5 rows, 2 columns, 10px gap)
   ├─ Window: 500×500 pixels, centered, EXIT_ON_CLOSE
   └─ Font: Arial, Bold, 20px (title)
```

### Data Flow Diagram

```
USER ACTION
    ↓
┌─────────────────────────────────┐
│  USER ENTERS BOOKING DETAILS    │
│  • Customer Name                │
│  • Select Room Type             │
│  • Enter Number of Days         │
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  VALIDATION LAYER               │
│  Check: Days is valid integer?  │
│  NO  → Show Error Dialog        │
│  YES → Continue                 │
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  BUSINESS LOGIC LAYER           │
│  1. Extract room price          │
│     (String contains "1500"?)   │
│  2. Calculate total             │
│     total = price × days        │
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  PRESENTATION LAYER             │
│  Show Confirmation Dialog       │
│  • Name                         │
│  • Room Type                    │
│  • Days                         │
│  • Total Amount                 │
└─────────────────────────────────┘
```

---

## 🔧 Requirements

### System Requirements
- **Java Development Kit (JDK)** - Version 8 or higher
- **Operating System** - Windows, macOS, or Linux
- **RAM** - Minimum 512 MB
- **Disk Space** - ~5 MB (class files)
- **Internet Connection** - Optional (only if opening website link)

### Environment Setup
- JDK installed and PATH configured
- Java compiler available in terminal/command prompt
- Text editor or IDE for viewing/editing code

---

## 📥 Installation & Setup

### Step 1: Verify Java Installation
```bash
# Check Java version
java -version

# Check Java compiler
javac -version
```

Expected output:
```
java version "1.8.0" or higher
javac 1.8.0 or higher
```

### Step 2: Create Project Directory
```bash
# Create project folder
mkdir HotelBookingSystem
cd HotelBookingSystem

# Or use your existing directory
```

### Step 3: Save Java File
Copy the `HotelRoomBookingSystem.java` file to your project directory.

### Step 4: Verify File
```bash
# List directory contents
ls -la          # macOS/Linux
dir             # Windows

# Should show: HotelRoomBookingSystem.java
```

---

## 🚀 Implementation Steps

### STEP 1: Compile the Java File

Open terminal/command prompt in your project directory:

```bash
javac HotelRoomBookingSystem.java
```

**What happens:**
- Java compiler reads `HotelRoomBookingSystem.java`
- Compiles code into bytecode
- Creates `HotelRoomBookingSystem.class` file
- Ready for execution

**Compilation output:**
```
HotelRoomBookingSystem.class  (Generated bytecode file)
HotelRoomBookingSystem.java   (Original source)
```

**If compilation fails:**
```bash
# Check for syntax errors
javac -verbose HotelRoomBookingSystem.java

# Verify imports
# Make sure these are available:
# - java.net.URI
# - javax.swing.*
# - java.awt.*
# - java.awt.event.*
```

---

### STEP 2: Run the Application

```bash
java HotelRoomBookingSystem
```

**What happens:**
1. JVM starts
2. Executes `main()` method
3. Opens website in default browser (optional)
4. Creates GUI window
5. Shows Hotel Room Booking System interface

**Expected output:**
```
GUI Window appears with:
- Title: "Hotel Room Booking System"
- Input fields for Name and Days
- Dropdown for Room selection
- Book Room and Clear buttons
```

---

### STEP 3: Test Functionality

#### Test Case 1: Valid Booking
```
Step 1: Enter Name → "Rajesh Kumar"
Step 2: Select Room → "Deluxe - ₹2500/day"
Step 3: Enter Days → "3"
Step 4: Click "Book Room"

Expected Result:
✓ Confirmation dialog shows:
  - Name: Rajesh Kumar
  - Room: Deluxe - ₹2500/day
  - Days: 3
  - Total Amount: ₹7500
```

#### Test Case 2: Invalid Days (Non-Integer)
```
Step 1: Enter Name → "Priya Sharma"
Step 2: Select Room → "Suite - ₹4000/day"
Step 3: Enter Days → "abc"
Step 4: Click "Book Room"

Expected Result:
✓ Error dialog appears: "Enter valid number of days!"
✓ No booking confirmation shown
```

#### Test Case 3: Clear Form
```
Step 1: Fill all fields
Step 2: Click "Clear"

Expected Result:
✓ Name field → Empty
✓ Days field → Empty
✓ Room selection → Resets to "Standard - ₹1500/day"
```

#### Test Case 4: Different Room Types
```
Standard Room Test:
- Room: "Standard - ₹1500/day"
- Days: "2"
- Expected Total: ₹3000 ✓

Suite Test:
- Room: "Suite - ₹4000/day"
- Days: "5"
- Expected Total: ₹20000 ✓
```

---

### STEP 4: Package & Deploy

#### Option A: Create JAR File
```bash
# Create manifest
echo Main-Class: HotelRoomBookingSystem > manifest.txt

# Create JAR
jar cvfm HotelRoomBookingSystem.jar manifest.txt HotelRoomBookingSystem.class

# Run JAR
java -jar HotelRoomBookingSystem.jar
```

#### Option B: Create Executable Batch/Shell Script

**Windows (.bat file):**
```batch
@echo off
cd /d %~dp0
java HotelRoomBookingSystem
pause
```

**macOS/Linux (.sh file):**
```bash
#!/bin/bash
cd "$(dirname "$0")"
java HotelRoomBookingSystem
```

Make executable:
```bash
chmod +x run.sh
./run.sh
```

---

## 🎯 Usage Guide

### Booking a Room - Step by Step

#### Step 1: Enter Customer Name
1. Click on the "Customer Name" text field
2. Type the guest's full name
3. Example: "Rajesh Kumar"

#### Step 2: Select Room Type
1. Click the dropdown next to "Room Type:"
2. Choose from:
   - **Standard** - ₹1,500 per day
   - **Deluxe** - ₹2,500 per day
   - **Suite** - ₹4,000 per day

#### Step 3: Enter Number of Days
1. Click on the "No. of Days" text field
2. Type the number (must be a positive integer)
3. Examples: 1, 2, 3, 7, 10, 30

#### Step 4: Book the Room
1. Click the "Book Room" button
2. System validates input
3. Confirmation dialog appears with:
   - Customer Name
   - Room Type & Price
   - Number of Days
   - **Total Amount to Pay**

#### Step 5: Clear and Book Again (Optional)
1. Click "Clear" button to reset all fields
2. Repeat process for next booking

---

### Booking Example Scenarios

**Scenario 1: Budget Traveler**
```
Name: Vikram Singh
Room: Standard - ₹1500/day
Days: 3
─────────────────────
Calculation: 1500 × 3 = ₹4,500
```

**Scenario 2: Business Stay**
```
Name: Priya Gupta
Room: Deluxe - ₹2500/day
Days: 7
─────────────────────
Calculation: 2500 × 7 = ₹17,500
```

**Scenario 3: Luxury Package**
```
Name: Arjun Patel
Room: Suite - ₹4000/day
Days: 5
─────────────────────
Calculation: 4000 × 5 = ₹20,000
```

---

## 💻 Code Components

### Component 1: Class Structure
```java
public class HotelRoomBookingSystem extends JFrame implements ActionListener
```
- **Extends JFrame**: Creates main application window
- **Implements ActionListener**: Handles button click events

### Component 2: Constructor
```java
public HotelRoomBookingSystem()
```
**Responsibilities:**
- Initialize GUI components (JLabel, JTextField, JComboBox, JButton)
- Set layout (GridLayout)
- Add components to frame
- Register action listeners
- Configure window (size, location, close operation)

### Component 3: Event Handler
```java
@Override
public void actionPerformed(ActionEvent e)
```
**Handles two events:**

**Book Button Event:**
1. Retrieve input: name, room, days
2. Parse and validate days (Integer.parseInt)
3. Extract price from room string
4. Calculate: total = price × days
5. Display confirmation dialog

**Clear Button Event:**
1. Reset nameField to empty
2. Reset daysField to empty
3. Reset roomBox to first item

### Component 4: Main Method
```java
public static void main(String[] args)
```
- Opens website in browser (optional)
- Creates HotelRoomBookingSystem window
- Initializes application

---

## 💰 Room Types & Pricing

| Room Type | Price/Day | 1 Day | 3 Days | 5 Days | 7 Days |
|-----------|-----------|-------|--------|--------|--------|
| Standard  | ₹1,500    | ₹1,500 | ₹4,500 | ₹7,500 | ₹10,500 |
| Deluxe    | ₹2,500    | ₹2,500 | ₹7,500 | ₹12,500 | ₹17,500 |
| Suite     | ₹4,000    | ₹4,000 | ₹12,000 | ₹20,000 | ₹28,000 |

### Pricing Logic
```
Formula: Total Amount = Room Price per Day × Number of Days

Standard: 1500 × days
Deluxe:   2500 × days
Suite:    4000 × days
```

---

## ⚠️ Troubleshooting

### Issue 1: "javac: command not found" or "javac is not recognized"
**Cause:** JDK not installed or not in PATH

**Solution:**
```bash
# macOS
brew install openjdk

# Ubuntu/Debian
sudo apt-get install default-jdk

# Windows: Download from oracle.com/java

# Verify installation
java -version
javac -version
```

### Issue 2: "Error: Main method not found in class"
**Cause:** Missing main method or wrong class name

**Solution:** Ensure main method exists:
```java
public static void main(String[] args) {
    new HotelRoomBookingSystem();
}
```

### Issue 3: "Enter valid number of days!" error when valid number entered
**Cause:** Text field might have spaces or non-numeric characters

**Solution:**
- ✅ Valid Input: `5`, `10`, `30`
- ❌ Invalid Input: `5 `, ` 5`, `5.5`, `5a`, `abc`

### Issue 4: Application window doesn't appear
**Cause:** Swing library issue or display problem

**Solution:**
```bash
# Restart application
java HotelRoomBookingSystem

# Or check for runtime errors
java HotelRoomBookingSystem 2>&1
```

### Issue 5: Website link doesn't open
**Cause:** Desktop.browse() not supported on your system

**Solution:** This is optional functionality. Comment out:
```java
// Desktop.getDesktop().browse(new URI("http://69329e3172078.site123.me"));
```

### Issue 6: Compilation errors with "cannot find symbol"
**Cause:** Missing imports or typos

**Solution:** Verify these imports exist:
```java
import java.net.URI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
```

---

## 🔐 Important Notes

### Data Handling
- **No Database**: Bookings are NOT saved to database
- **In-Memory Only**: Data exists only during application runtime
- **No Persistence**: Closing app clears all booking data

### Currency & Localization
- **Currency**: Indian Rupees (₹) used throughout
- **Language**: English interface
- **Format**: Amount shown as ₹XXXX

### Security Notes
- **Input Validation**: Days field validated as integer
- **No SQL Injection**: No database queries
- **No Authentication**: Open access application

### Limitations
- Single user interface (no multi-user support)
- No booking history/records
- No payment gateway integration
- No email confirmations
- No room availability tracking

---

## 🎯 Future Enhancements

### Phase 1: Data Management
1. **Database Integration**
   - MySQL/SQLite database
   - Store booking records
   - Retrieve booking history

2. **File Storage**
   - Save bookings to CSV/JSON
   - Export reports
   - Backup data

### Phase 2: Advanced Features
1. **Booking Management**
   - Cancel booking
   - Modify existing bookings
   - Search past bookings

2. **Payment Integration**
   - Payment gateway (PayPal, Stripe)
   - Invoice generation
   - Receipt printing

3. **User Management**
   - Customer accounts
   - Admin login
   - User authentication

### Phase 3: Smart Features
1. **Intelligent Pricing**
   - Dynamic pricing
   - Seasonal discounts
   - Coupon codes
   - Loyalty programs

2. **Analytics & Reporting**
   - Revenue reports
   - Room occupancy stats
   - Customer analytics
   - Dashboard

3. **Communication**
   - Email confirmation
   - SMS notifications
   - Calendar integration
   - Reminder system

### Phase 4: UI/UX Improvements
1. **Modern Interface**
   - Nimbus Look & Feel
   - Dark mode support
   - Responsive design
   - Better graphics

2. **User Experience**
   - Date picker for check-in/check-out
   - Real-time availability
   - Room preview images
   - Guest reviews

---

## 📝 Complete Implementation Checklist

- [ ] JDK installed and configured
- [ ] Java source file saved
- [ ] File compiled successfully (`*.class` created)
- [ ] Application runs without errors
- [ ] GUI displays correctly
- [ ] All buttons functional
- [ ] Input validation works
- [ ] Calculations correct
- [ ] Confirmation dialog shows
- [ ] Clear button resets fields
- [ ] Tested with multiple scenarios
- [ ] JAR file created (optional)
- [ ] Executable script created (optional)

---

## 📧 Quick Reference

### Commands
```bash
# Compile
javac HotelRoomBookingSystem.java

# Run
java HotelRoomBookingSystem

# Create JAR
jar cvfm app.jar manifest.txt HotelRoomBookingSystem.class

# Run JAR
java -jar app.jar
```

### Room Prices Quick Lookup
```
Standard: ₹1,500/day
Deluxe:   ₹2,500/day
Suite:    ₹4,000/day
```

### Test Inputs
```
Valid: "Rajesh", "3", "Standard - ₹1500/day"
Invalid: "abc" (for days), "Deluxe" (for days)
```

---

  
**Language:** Java (Swing)  

**Contact:**[https://github.com/vanamavrshini6][http://vanamvarshini6/Hotel-room-bookin-system

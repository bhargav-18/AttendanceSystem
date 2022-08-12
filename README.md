
# Attendance System

Manage attendance of faculties and students with help of face recognition through phone's camera.

## How to Build this app

1. Open android studio and click on file on the menu ribbon, then click on new project from version control.

![alternatetext](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot%202021-11-26%20204100.jpg)

2. Copy this repository's url or copy this link https://github.com/bhargav-18/TournamentMaker.git and paste it in the URL field and click on clone.
It will clone this app in your personal pc.

![alternatetext](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot%202022-08-12%20223253.jpg)

3. Click on build tab and build apk to use this app on your mobile device. It will create an apk that can be shared and can be installed on multiple devices.

![alternatetext](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot%202021-11-26%20204540.jpg)

4. The app can be found in your computer at the below mentioned path.

Drive:/project-name/app/build/outputs/

## Tech/Dependencies's used

1.  Used MVVM architecture for cleaner code
2.  Used firebase for backend like: 
- authentication
- to store data (firestore) 
- to detect face (firebase face detection)
- to analyze crashs (firebase crashalytics)
- for remote configurations (firebase remote config)
3. Used coroutines for background processes.
4. Used okhttp3 to create HTTP requests.
5. Used facenet.tflite model for face recognition.
6. Created REST Api in python using flask for attendance sheet generation and updation and also for recognizing multiple faces, and for returning information of faculty getting unique number as input. 

## Screenshots

![App Screenshot](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot_20220812-202331_Attendance%20System.jpg)

![App Screenshot](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot_20220812-202335_Attendance%20System.jpg)

![App Screenshot](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot_20220812-202339_Attendance%20System.jpg)

![App Screenshot](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot_20220812-202343_Attendance%20System.jpg)

![App Screenshot](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot_20220812-202309_Attendance%20System.jpg)

![App Screenshot](https://github.com/bhargav-18/AttendanceSystem/blob/main/Screenshots/Screenshot_20220812-202315_Attendance%20System.jpg)

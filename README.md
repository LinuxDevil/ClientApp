
## Base Structure
  The app is based on the Serverless architecture (FaaS) for the Back-end, 
  based on the AWS Lambda platform.
  The Front-end is an android application.
  
## Android Structure
  * The Android application is built using the MVVM design pattern.
  * The Application can also be used offline (We store the posts and fetch them every hour or if there's any new post).
  
  ![MVVM Design Pattern](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
  
  ## Libraries Used:
   - [Retrofit](https://github.com/square/retrofit)
   - [GSON](https://github.com/google/gson)
   - [Material Components](https://github.com/material-components/material-components-android)
   - [Kodein](https://github.com/Kodein-Framework/Kodein-DI)
   - [CircleImageView](https://github.com/hdodenhof/CircleImageView)
   - [Groupie](https://github.com/lisawray/groupie)
   - [AnimatedBottomBar](https://github.com/Droppers/AnimatedBottomBar)

## Stack
  The app is based on AWS services mostly. Services include:
    - AWS API Gateway       (REST API Endpoints)
    - AWS LAMBDA            (Serverless Business Logic)
    - MongoDB Atlas         (Database Solution)
    - MongoDB Atlas Search  (Search Solution)
    - AWS Cloudwatch        (Logs)

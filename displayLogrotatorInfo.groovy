/**
This Script loops trough all your Jenkins jobs, and reports all the jobs where the configuration of the logRotator is out of standard
This print out each Job in the format ${jobName} DaysToKeep {daysToKeep} #builds ${#number of builds for the job}
and in the buttom a total count of misconfigured jobs.

Parameters:
_________________
* daysToKeep  -> The number of days that you wish to keep logs and build info
* adaysToKeep -> The number of days to keep artifacts
*/
daysToKeep  = 14 
aDaysToKeep = 14

counter = 0
jenkins.model.Jenkins.instance.getAllItems(hudson.model.Job).each {
  if(it.logRotator!=null){
    if (
      	(it.logRotator.daysToKeep<0 || it.logRotator.daysToKeep> daysToKeep) &&
      	(it.logRotator.artifactDaysToKeep < 0 ||it.logRotator.artifactDaysToKeep < aDaysToKeep )
       ){
      	println ""+it.fullDisplayName + " \n\tDaysToKeep ->  "+ it.logRotator.daysToKeep + " \n\t#Builds " + it.builds.size()
      	counter++
          if (!it instanceof hudson.matrix.MatrixBuild ){
        	it.logRotator = new hudson.tasks.LogRotator ( 14, -1, 14, -1) // days to keep, num to keep, artifact days to keep, num to keep
          }
    }
  }
} 

//Rotates the newly configured log settings
Jenkins.instance.getAllItems(Job.class)
.findAll { it.logRotator }
    .each {
      it.logRotator.perform(it)
    }
println "number of misconfigured jobs: " +counter

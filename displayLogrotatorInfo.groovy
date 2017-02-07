/**
This Script loops trough all your Jenkins jobs, and reports all the jobs where the configuration of the logRotator is out of standard
This print out each Job in the format ${jobName} -> {daysToKeep}
and in the buttom a total count of misconfigured jobs.

Parameters:
_________________
* daysToKeep -> The number of days that you wish to keep jobs

*/
daysToKeep = 14


counter = 0
jenkins.model.Jenkins.instance.getAllItems(hudson.model.Job).each {
  if(it.logRotator!=null){
    if (it.logRotator.daysToKeep<0 || it.logRotator.daysToKeep> daysToKeep){
      	counter++
        //potentially you can add a new logrotator here
  		println ""+it.fullDisplayName + " -> "+ it.logRotator.daysToKeep
    }
  }
} 
println "number of misconfigured jobs: " +counter

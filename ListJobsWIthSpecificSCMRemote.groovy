import hudson.plugins.emailext.*
import hudson.model.*
import hudson.maven.*
import hudson.maven.reporters.*
import hudson.tasks.*
import hudson.scm.*

 def counter = 0
def jobsNames='no'  
def scmString='ebt'

jobs = Hudson.instance.items
for (item in jobs){
  if(item.name.contains(jobsNames)){
    if (item.scm instanceof SubversionSCM) {
      item.scm.locations.each{
        println(it.remote)
       //For every Subversion-Location
       if (it.remote.contains(scmString)) {
        counter++
  		println(item.name)
       }
      }
    }
  }
}


println("Total job: "+counter)

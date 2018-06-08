/**
The intention of this script is to loop trugh all jobs on the server an print the job name and url, if the url matches the $url_regex
This is intended for SCM configurations of type hudson.plugins.git.GitSCM.
If if find a Folder object it recursively loops trough this also

If you are not looking for "bitbucket.com" just change the url_regex to a regular expression that matches your search criteria.
*/

url_regex = 'bitbucket.com'

def checkBitbucker(job, scm){
	if (scm.class.name == 'hudson.plugins.git.GitSCM') {
      if (scm.getUserRemoteConfigs() =~ /${url}/ ){
    	println "Job '${job.name}' uses the following git configuration"
      	println "\tRemote:     ${scm.getUserRemoteConfigs()[0].getUrl()}"
      }
	}
}

def printJobInfo(job){
  if (job.class.name =='com.cloudbees.hudson.plugins.folder.Folder'){
    job.getAllJobs().each{ child ->
      printJobInfo(child) //Recursively call it self everytime it finds a Folder object
    }
  }else if(job.class.name =='org.jenkinsci.plugins.workflow.job.WorkflowJob'){
    job.getSCMs().each{ scm ->
    	checkBitbucker(job, scm)
    }
  }else{
    checkBitbucker(job, job.scm)
  }
}

hudson.model.Hudson.instance.items.each{ job ->
  printJobInfo(job)
}

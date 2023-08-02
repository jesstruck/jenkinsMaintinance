import jenkins.model.Jenkins
import hudson.model.Job
import hudson.model.AbstractItem

safe_date = new Date().plus(-90)

def cleanJob(hudson.model.AbstractItem item){
  switch (item) {
    case org.jenkinsci.plugins.workflow.job.WorkflowJob:
    case com.cloudbees.hudson.plugins.folder.Folder:
      item.getAllJobs().each { job ->
        println("Currently looking at job: " + job.name)
        cleanJob(job)
      }
      break
    case Job:
      println item.name
      for (build in item.builds) {
        if (build.getTime() < safe_date) {
          println "Preparing to delete: " + build
          // build.delete()
        }
      }
      break
    default:
      println("We currently don't support " + item.name)
  }
}

LIMIT = 20 //Limits the number of jobs to clean
Jenkins.instance.items.each { item ->
  println item.name
  if (LIMIT > 1) {
    cleanJob(item)
    LIMIT--
  }
}

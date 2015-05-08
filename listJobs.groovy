import hudson.plugins.emailext.*
import hudson.model.*
import hudson.maven.*
import hudson.maven.reporters.*
import hudson.tasks.*

def updated = 0
def counter = 0
jobs = Hudson.instance.items
for (item in jobs){
  if(item.name.startsWith('SOMETHING-')){
    counter++
  	for (publisher in item.publishersList){
    	if(publisher instanceof Mailer) {
    		println(item.name + " " + publisher.recipients)// + " " + publisher.properties)
          	updated++
        }
  	}
  }
}

println(counter-updated)

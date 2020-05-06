node ('dev'){
	stage('Build') {
		if (env.BRANCH_NAME == 'dev') {
			checkout scm
			echo 'Runnig SE Grid Job'
			build 'selenium_grid_docker'
		}
	}	
	stage('Test') {	
		if (env.BRANCH_NAME == 'dev') {
			echo 'Runnig Maven test'
			build 'test_code'
		} 
   	}
}

node ('prod'){
	stage('Build') {
		if (env.BRANCH_NAME == 'master') {
			checkout scm
			echo 'Runnig SE Grid Job'
			build 'selenium_grid_docker'
		}
	}		
	stage('Test') {	
		if (env.BRANCH_NAME == 'master') {
			echo 'Runnig Maven test'
			build 'test_code'
		} 
   	}   
   	stage('Deploy'){
		if (env.BRANCH_NAME == 'master') {
			echo 'Runnig Production Push as its master branch commit'
			build 'prod_push'
		}
   	}   
}

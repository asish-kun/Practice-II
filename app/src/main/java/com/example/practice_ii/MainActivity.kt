package com.example.practice_ii

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var itemListView: ListView
    private lateinit var items: List<ListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        items = listOf(
            ListItem("Launch Starship", "SpaceX", "Prepare for the next orbital launch of Starship."),
            ListItem("Tesla AI Day", "Tesla", "Organize and present the latest advancements in Tesla's AI technology."),
            ListItem("Mars Colony Planning", "SpaceX", "Review the plans for the first Mars colony and finalize resource requirements."),
            ListItem("Neuralink Update", "Neuralink", "Check the progress of the brain-machine interface and plan the next demonstration."),
            ListItem("Boring Company Tunnel Expansion", "Boring Company", "Evaluate the feasibility of expanding the Las Vegas tunnel system."),
            ListItem("Twitter Feature Rollout", "Twitter", "Oversee the rollout of new features for better user engagement."),
            ListItem("Hyperloop Development", "Boring Company", "Assess the latest designs and logistics for the Hyperloop transportation system."),
            ListItem("Starlink Global Expansion", "SpaceX", "Plan the expansion of Starlink internet services to underserved areas globally."),
            ListItem("Tesla Gigafactory Optimization", "Tesla", "Improve efficiency and output of Gigafactories to meet increasing demand."),
            ListItem("Raptor Engine Testing", "SpaceX", "Supervise ongoing tests and development of the Raptor engine for future missions."),
            ListItem("Brainstorm Tesla Robot Updates", "Tesla", "Work on updates for Optimus, Tesla's humanoid robot for commercial applications."),
            ListItem("Plan SolarCity Integration", "Tesla", "Advance plans for integrating SolarCity products more seamlessly with Tesla Energy."),
            ListItem("Artificial Gravity Experiment", "SpaceX", "Prepare for tests to simulate artificial gravity for long-duration space missions."),
            ListItem("Renewable Energy Solutions for Mars", "SpaceX", "Work on renewable energy technology for Mars, including solar and wind solutions."),
            ListItem("Tesla Semi Truck Rollout", "Tesla", "Finalize plans for the commercial launch of the Tesla Semi."),
            ListItem("Rocket Refueling in Orbit", "SpaceX", "Develop refueling techniques for missions that require extended durations in orbit."),
            ListItem("Boring Company New Tunneling Project", "Boring Company", "Explore new city partnerships for underground transportation systems."),
            ListItem("Tesla Autonomous Driving Milestones", "Tesla", "Reach the next level of autonomy in Tesla's Full Self-Driving software."),
            ListItem("Neuralink Human Trials", "Neuralink", "Plan the next phase of human trials for the brain-machine interface technology."),
            ListItem("Terraforming Mars Research", "SpaceX", "Continue research into the long-term potential for terraforming Mars."),
            ListItem("Tesla Cybertruck Production", "Tesla", "Monitor the final stages of Cybertruck production and prepare for market launch."),
            ListItem("Plan Next Mars Rover Mission", "SpaceX", "Strategize for the next unmanned mission to Mars to deploy advanced rovers."),
            ListItem("Tesla AI Integration with Energy Grid", "Tesla", "Develop AI-driven systems for optimizing renewable energy usage across power grids."),
            ListItem("SpaceX Mars Cargo Ship Design", "SpaceX", "Finalize design specifications for cargo ships that will deliver essential goods to Mars."),
            ListItem("Starbase Infrastructure Expansion", "SpaceX", "Expand the infrastructure at Starbase for supporting frequent space missions."),
            ListItem("Update Tesla Energy Products", "Tesla", "Enhance Tesla Energy products like the Powerwall and solar roofs for efficiency and durability.")

        )

        itemListView = findViewById(R.id.itemListView)
        val adapter = ItemAdapter(this, items)
        itemListView.adapter = adapter

        itemListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = items[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("subtitle", item.subtitle)
            intent.putExtra("description", item.description)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val coordinatorLayout: CoordinatorLayout = findViewById(R.id.coordinatorLayout)
        Snackbar.make(coordinatorLayout, "Returned to MainActivity", Snackbar.LENGTH_SHORT).show()
    }
}

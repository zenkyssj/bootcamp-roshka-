import { useState, type JSX } from "react"

import { Expandible } from "./components/ExpandibleElements"
import { Card } from "./components/Card"
import { Label } from "./components/Label"
import { Button } from "./components/Button"
import { Navbar } from "./components/Navbar"
import { Banner } from "./components/Banner"
import { Footer } from "./components/Footer"

import cardImage from './assets/card.png'

const expElements = [
    {
        id: '2',
        title: 'HoldBack',
        content: 'Holdback estimates the point at which a well turns from an asset to a liability. Using a basic cash flow model that integrates' +
          'estimated plugging costs, holdback identifies the moment in time when all future undiscounted cash flows mus be "held back" to cover the cost to retire the well. '
    },
    {
        id: '3',
        title: 'Financial Assurance',
        content: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis earum non nam expedita accusamus, cum nisi quia placeat ex explicabo tempore deserunt impedit quaerat quae, dolorum distinctio vitae doloremque provident.'
    },
    {
      id: '4',
      title: 'Liability Ringfencing',
      content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla ab odio rerum accusamus minus libero officia praesentium. Reiciendis, impedit quae deleniti sapiente quo officia modi, autem nulla enim assumenda repellat.'
    },
    {
      id: '5',
      title: 'ARO Creditor Rights',
      content: 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Similique aliquid sint totam incidunt adipisci explicabo eos fugit nobis esse animi voluptate corrupti nulla, iusto debitis dolores quidem earum! Dignissimos, aspernatur.'
    },
    {
      id: '6',
      title: 'Join and Several Liability',
      content: 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugit minus est quidem, exercitationem voluptatibus dicta, molestias doloribus, ratione aliquam quis ducimus quibusdam reiciendis ab unde amet recusandae enim et voluptatum!'
    },
    {
      id: '7',
      title: 'Colorado',
      content: 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sapiente quas culpa eum ipsum labore beatae officia vitae quos enim, dignissimos similique velit laborum ullam quo ducimus, nostrum, impedit modi doloribus.'
    },
    {
      id: '8',
      title: 'Joint and Several Liability',
      content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat unde amet eaque laboriosam voluptas. Totam accusantium debitis expedita dicta repudiandae. Libero, ducimus adipisci excepturi laboriosam neque eius quae consequuntur ipsum!'
    },
    {
      id: '9',
      title: 'ARO Moral Hazard',
      content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis sunt magnam eaque reiciendis ipsam, iusto non, corrupti nostrum enim, soluta facere fuga eius molestiae ullam deleniti placeat? Est, nostrum. Consequuntur.'
    }

]

const cardElements = {
  img: cardImage,
  title: "It's Closing Time",
  description: "Billion Dollar Orphans estimate that pluggin 2.6 million document onshore wells in the U.S. alone will cost $280 billion. This estimate excludes costs to plug an additional estimated 1.2 million undocumented onshore wells",
  links: [
    {
      linkTitle: "READ REPORT"
    },
    {
      linkTitle: "DOWNLOAD REPORT"
    }
  ]
}

const labelElements = [
  {
    id: '1',
    title: 'Label',
    content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil eaque dolorum commodi odit aliquam numquam distinctio obcaecati doloribus dolores, aliquid nesciunt quam delectus placeat quae doloremque natus, excepturi architecto ipsam?'
  },
  {
    id: '2',
    title: 'Label',
    content: 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Deserunt perspiciatis, doloribus animi eius modi porro reiciendis beatae quos ipsa vitae, odio repellat excepturi impedit. Nam doloremque tempora atque et. Ab?'
  },
  {
    id: '3',
    title: 'Label',
    content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque in rem facilis dicta et dolorum quod, tempora placeat odio id error cupiditate accusantium delectus? Corporis ut dolorem voluptatibus quas nisi.'
  }
]


const App = (): JSX.Element => {
    const [expands] = useState(expElements);
    const [card] = useState(cardElements);
    const [label] = useState(labelElements);

    return (
        <>
            <Navbar
                onLogin={() => console.log('Login clicked')} 
                onBookDemo={() => console.log('Book Demo clicked')} 
            />

            
            <Banner 
                title="Work less, achieve more."
                description="Our technology is the key to unlocking higher sales and better service. We stand behind it with a satisfaction guarantee - try it risk-free and see the results for yourself!"
                buttonText="GET STARTED"
                onButtonClick={() => console.log('Get Started clicked')}
            />

            <Expandible expandibleElements = {expands} />
            <Card card = {card} />
            <Label labelElements = {label} />
            <div style={{ display: 'flex', gap: '10px', flexWrap: 'wrap', padding: '20px' }}>
              <Button label="LABEL" variant='primary'/>
              <Button label="LABEL" variant="secondary" />
              <Button label="LABEL" variant="disabled" />

              <Button label="LABEL" variant="primary" style="withIconLeft"></Button>
              <Button label="LABEL" variant="secondary" style="withIconLeft"></Button>
              <Button label="LABEL" variant="disabled" style="withIconLeft"></Button>

              <Button label="LABEL" variant="primary" style="withIconRight"></Button>
              <Button label="LABEL" variant="secondary" style="withIconRight"></Button>
              <Button label="LABEL" variant="disabled" style="withIconLeft"></Button>

              <Button label="LABEL" variant="outlined" />
              <Button label="LABEL" variant="outlined-secondary"/>
              <Button label="LABEL" variant="outlined-disabled"/>

              <Button label="LABEL" variant="outlined" style="withIconLeft"/>
              <Button label="LABEL" variant="outlined-secondary" style="withIconLeft"/>
              <Button label="LABEL" variant="outlined-disabled" style="withIconLeft"/>

              <Button label="LABEL" variant="outlined" style="withIconRight"/>
              <Button label="LABEL" variant="outlined-secondary" style="withIconRight"/>
              <Button label="LABEL" variant="outlined-disabled" style="withIconRight"/>

            </div>

            <Footer />
        </>
    )
}

export default App
